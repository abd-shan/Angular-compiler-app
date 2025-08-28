package semantic;

import symbolTable.Scope;
import symbolTable.Symbol;
import symbolTable.SymbolTable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalyzer {
    private final SymbolTable tsTable;
    private final SymbolTable templateTable;
    private final List<String> errors = new ArrayList<>();

    public SemanticAnalyzer(SymbolTable tsTable, SymbolTable templateTable) {
        this.tsTable = tsTable;
        this.templateTable = templateTable;
    }

    public void analyze() {
        // ✅ Angular template checks
        checkUndefinedMethodsInTemplates();
        checkUndefinedBaseIdentifiersInBindings();
        checkNgForCollections();
        checkNgIfVariables();
        checkMethodParameterVariables();

        // ✅ TypeScript semantic checks
        checkUndefinedThisVariables();
        checkUndefinedVariablesInMethodCalls();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    private Scope getRoot(SymbolTable table) {
        Scope cur = table.getCurrentScope();
        if (cur == null) return null;
        while (cur.getParent() != null) cur = cur.getParent();
        return cur;
    }

    private Scope findScopeByName(Scope root, String name) {
        if (root == null) return null;
        Queue<Scope> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Scope s = q.poll();
            if (name.equals(s.getName())) return s;
            q.addAll(s.getChildren());
        }
        return null;
    }

    private List<Scope> getTemplateComponentScopes() {
        List<Scope> res = new ArrayList<>();
        Scope root = getRoot(templateTable);
        if (root == null) return res;
        res.addAll(root.getChildren());
        return res;
    }

    private Scope getTsComponentScopeByName(String componentName) {
        Scope tsRoot = getRoot(tsTable);
        if (tsRoot == null) return null;
        return findScopeByName(tsRoot, componentName);
    }

    // Angular template symbol type detection
    private boolean isClickEvent(Symbol sym) {
        return sym.getName() != null && sym.getName().contains("(click)");
    }

    private boolean isNgModelBinding(Symbol sym) {
        return sym.getName() != null && sym.getName().contains("[(ngModel)]");
    }

    private boolean isPropertyBinding(Symbol sym) {
        String n = sym.getName();
        return n != null && n.matches(".*\\.\\[[^\\]]+\\]#\\d+.*");
    }

    private boolean isInterpolation(Symbol sym) {
        return sym.getName() != null && sym.getName().contains("{{");
    }

    private boolean isNgFor(Symbol sym) {
        return sym.getName() != null && sym.getName().contains("*ngFor");
    }

    private boolean isNgIf(Symbol sym) {
        return sym.getName() != null && sym.getName().contains("*ngIf");
    }

    private boolean isTemplateLocalVar(Symbol sym) {
        return "ngForVar".equalsIgnoreCase(sym.getType());
    }

    private String extractMethodName(String callExpr) {
        if (callExpr == null) return null;
        int p = callExpr.indexOf('(');
        return (p > 0) ? callExpr.substring(0, p).trim() : callExpr.trim();
    }

    private String extractRhsExpression(Symbol sym) {
        return sym.getType();
    }

    private String extractBaseIdentifier(String expr) {
        if (expr == null) return null;
        Matcher m = Pattern.compile("([A-Za-z_\\$][A-Za-z0-9_\\$]*)").matcher(expr);
        return (m.find()) ? m.group(1) : null;
    }

    // Extract ngIf/ngFor directive expression
    private String extractDirectiveExpression(Symbol sym) {
        if (sym.getName() == null) return null;

        Matcher matcher = Pattern.compile("\\*ng(If|For)\\s*=\\s*[\"']([^\"']+)[\"']").matcher(sym.getName());
        if (matcher.find()) {
            return matcher.group(2);
        }

        String typeExpression = sym.getType();
        if (typeExpression != null && !typeExpression.trim().isEmpty()) {
            return typeExpression;
        }

        return null;
    }

    private List<String> extractVariableFromNgIfExpression(String expr) {
        List<String> vars = new ArrayList<>();
        if (expr == null) return vars;

        String cleanedExpr = expr.replaceAll("[!&|()\\[\\].]", " ").trim();

        Matcher m = Pattern.compile("([A-Za-z_\\$][A-Za-z0-9_\\$]*)").matcher(cleanedExpr);
        while (m.find()) {
            String variable = m.group(1);
            if (!isReservedKeyword(variable)) {
                vars.add(variable);
            }
        }
        return vars;
    }

    private boolean isReservedKeyword(String word) {
        return Set.of("ngIf", "ngFor", "let", "of", "true", "false", "null", "undefined").contains(word);
    }

    // Extract method parameters from call expression
    private List<String> extractMethodParameters(String callExpr) {
        List<String> params = new ArrayList<>();
        if (callExpr == null || !callExpr.contains("(")) return params;

        int start = callExpr.indexOf('(');
        int end = callExpr.lastIndexOf(')');
        if (start == -1 || end == -1 || end <= start) return params;

        String paramStr = callExpr.substring(start + 1, end).trim();
        if (paramStr.isEmpty()) return params;

        String[] parts = paramStr.split(",(?=(?:[^'\"]*['\"][^'\"]*['\"])*[^'\"]*$)");
        for (String part : parts) {
            params.add(part.trim());
        }
        return params;
    }

    private String extractCollectionFromNgFor(String expr) {
        if (expr == null) return null;

        Pattern pattern = Pattern.compile("(?:let\\s+[a-zA-Z_$][\\w$]*\\s+)?of\\s+([a-zA-Z_$][\\w$]*)");
        Matcher matcher = pattern.matcher(expr);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    // ---------------- TEMPLATE SEMANTIC CHECKS ----------------
    private void checkUndefinedMethodsInTemplates() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsScope = getTsComponentScopeByName(componentName);
            if (tsScope == null) continue;

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                if (!isClickEvent(sym)) continue;

                String callExpr = Optional.ofNullable(extractRhsExpression(sym)).orElse(sym.getName());
                String method = extractMethodName(callExpr);
                if (method == null || method.isBlank()) continue;

                if (tsScope.resolve(method) == null) {
                    errors.add(formatError(componentName, sym,
                            "Undefined method '" + method + "' referenced in template event."));
                }
            }
        }
    }

    private void checkUndefinedBaseIdentifiersInBindings() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsScope = getTsComponentScopeByName(componentName);
            if (tsScope == null) continue;

            Set<String> localVars = new HashSet<>();
            for (Symbol s : tplCompScope.getSymbols().values()) {
                if (isTemplateLocalVar(s)) {
                    localVars.add(s.getName());
                }
            }

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                String rhs = null;

                if (isNgModelBinding(sym) || isPropertyBinding(sym)) {
                    rhs = extractRhsExpression(sym);
                } else if (isInterpolation(sym)) {
                    Matcher m = Pattern.compile("\\{\\{\\s*(.*?)\\s*\\}\\}").matcher(sym.getName());
                    if (m.find()) rhs = m.group(1);
                }

                if (rhs == null || rhs.isBlank()) continue;

                String base = extractBaseIdentifier(rhs);
                if (base == null || localVars.contains(base)) continue;

                if (tsScope.resolve(base) == null) {
                    errors.add(formatError(componentName, sym,
                            "Undefined identifier '" + base + "' in expression '" + rhs + "'."));
                }
            }
        }
    }

    private void checkNgIfVariables() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsScope = getTsComponentScopeByName(componentName);
            if (tsScope == null) continue;

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                if (!isNgIf(sym)) continue;

                String expr = extractDirectiveExpression(sym);

                if (expr == null || expr.isBlank()) {
                    errors.add(formatError(componentName, sym, "*ngIf directive is empty."));
                    continue;
                }

                List<String> variables = extractVariableFromNgIfExpression(expr);
                if (variables.isEmpty()) continue;

                for (String variable : variables) {
                    if (tsScope.resolve(variable) == null) {
                        errors.add(formatError(componentName, sym,
                                "Undefined variable '" + variable + "' used in *ngIf expression: " + expr));
                    }
                }
            }
        }
    }

    private void checkNgForCollections() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsScope = getTsComponentScopeByName(componentName);
            if (tsScope == null) continue;

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                if (!isNgFor(sym)) continue;

                String expr = extractDirectiveExpression(sym);
                if (expr == null || expr.isBlank()) {
                    errors.add(formatError(componentName, sym, "*ngFor directive is empty."));
                    continue;
                }

                String collection = extractCollectionFromNgFor(expr);
                if (collection == null) {
                    errors.add(formatError(componentName, sym, "Invalid *ngFor expression: " + expr));
                    continue;
                }

                if (tsScope.resolve(collection) == null) {
                    errors.add(formatError(componentName, sym,
                            "Undefined collection '" + collection + "' used in *ngFor."));
                }
            }
        }
    }

    private void checkMethodParameterVariables() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsScope = getTsComponentScopeByName(componentName);
            if (tsScope == null) continue;

            Set<String> localVars = new HashSet<>();
            for (Symbol s : tplCompScope.getSymbols().values()) {
                if (isTemplateLocalVar(s)) {
                    localVars.add(s.getName());
                }
            }

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                if (!isClickEvent(sym)) continue;

                String callExpr = Optional.ofNullable(extractRhsExpression(sym)).orElse(sym.getName());
                String method = extractMethodName(callExpr);
                if (method == null || method.isBlank()) continue;

                List<String> params = extractMethodParameters(callExpr);
                for (String param : params) {
                    String base = extractBaseIdentifier(param);
                    if (base == null || localVars.contains(base)) continue;

                    if (tsScope.resolve(base) == null) {
                        errors.add(formatError(componentName, sym,
                                "Variable '" + base + "' passed to method '" + method + "' is not defined."));
                    }
                }
            }
        }
    }

    // ---------------- TYPESCRIPT SEMANTIC CHECKS ----------------
    private void checkUndefinedThisVariables() {
        Scope root = getRoot(tsTable);
        if (root == null) return;

        Queue<Scope> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Scope scope = q.poll();
            q.addAll(scope.getChildren());

            for (Symbol sym : scope.getSymbols().values()) {
                String raw = sym.getType() != null ? sym.getType() : sym.getName();
                if (raw == null) continue;

                Matcher m = Pattern.compile("\\bthis\\.([A-Za-z_\\$][A-Za-z0-9_\\$]*)").matcher(raw);
                while (m.find()) {
                    System.out.println("888888888");

                    String varName = m.group(1);
                    if (scope.resolve(varName) == null) {
                        System.out.println("888888888");

                        errors.add("[TS Scope: " + scope.getName() + "] Undefined variable '" + varName +
                                "' accessed via 'this.' (at: " + raw + ")");
                    }
                }
            }
        }
    }

    private void checkUndefinedVariablesInMethodCalls() {
        Scope root = getRoot(tsTable);
        if (root == null) return;

        Queue<Scope> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Scope scope = q.poll();
            q.addAll(scope.getChildren());

            for (Symbol sym : scope.getSymbols().values()) {
                String raw = sym.getType() != null ? sym.getType() : sym.getName();
                if (raw == null || !raw.contains("(")) continue;

                List<String> params = extractMethodParameters(raw);
                for (String param : params) {
                    String base = extractBaseIdentifier(param);
                    if (base == null) continue;

                    if (scope.resolve(base) == null) {
                        errors.add("[TS Scope: " + scope.getName() + "] Undefined variable '" + base +
                                "' used as argument in method call (at: " + raw + ")");
                    }
                }
            }
        }
    }


    private String formatError(String componentName, Symbol sym, String msg) {
        if (sym.getLine() > 0 && sym.getColumn() > 0) {
            return "[Component: " + componentName + "] " + msg +
                    " (at line " + sym.getLine() + ", column " + sym.getColumn() + ")";
        } else {
            return "[Component: " + componentName + "] " + msg + " (at: " + sym.getName() + ")";
        }
    }
}
