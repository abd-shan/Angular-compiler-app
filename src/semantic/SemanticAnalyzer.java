package semantic;

import symbolTable.Scope;
import symbolTable.Symbol;
import symbolTable.SymbolTable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalyzer {

    private final SymbolTable tsTable;        // TypeScript (classes/components/members)
    private final SymbolTable templateTable;  // Template (bindings/events/etc.)
    private final List<String> errors = new ArrayList<>();

    public SemanticAnalyzer(SymbolTable tsTable, SymbolTable templateTable) {
        this.tsTable = tsTable;
        this.templateTable = templateTable;
    }

    public void analyze() {
        checkUndefinedMethodsInTemplates();
        checkUndefinedBaseIdentifiersInBindingsAndInterpolations();
        checkNgForCollections();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    /* ======================== Helpers: Scope traversal ======================== */

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

    /* ======================== Helpers: Kind detection ======================== */

    private boolean isClickEvent(Symbol sym) {
        String n = sym.getName();
        return n != null && n.contains("(click)");
    }

    private boolean isNgModelBinding(Symbol sym) {
        String n = sym.getName();
        return n != null && n.contains("[(ngModel)]");
    }

    private boolean isPropertyBinding(Symbol sym) {
        String n = sym.getName();
        return n != null && n.matches(".*\\.\\[[^\\]]+\\]#\\d+.*");
    }

    private boolean isRouterLink(Symbol sym) {
        String n = sym.getName();
        return n != null && n.contains("routerLink");
    }


    private boolean isTemplateLocalVar(Symbol sym) {
        String t = sym.getType();
        return "ngForVar".equalsIgnoreCase(t);
    }

    private boolean isInterpolation(Symbol sym) {
        String n = sym.getName();
        return n != null && n.contains("{{");
    }

    private boolean isNgFor(Symbol sym) {
        String n = sym.getName();
        return n != null && n.contains("*ngFor");
    }

    private boolean isNgIf(Symbol sym) {
        String n = sym.getName();
        return n != null && n.contains("*ngIf");
    }

    /* ======================== Helpers: Extract expressions ======================== */

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
        if (m.find()) return m.group(1);
        return null;
    }

    /* ======================== Checks ======================== */

    /** check undefine method in (click) */
    private void checkUndefinedMethodsInTemplates() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsCompScope = getTsComponentScopeByName(componentName);
            if (tsCompScope == null) continue;

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                if (!isClickEvent(sym)) continue;

                String callExpr = extractRhsExpression(sym);
                if (callExpr == null || callExpr.isBlank()) {
                    callExpr = sym.getName();
                }

                String method = extractMethodName(callExpr);
                if (method == null || method.isBlank()) continue;

                if (tsCompScope.resolve(method) == null) {
                    errors.add(err(componentName, sym,
                            "Undefined method '" + method + "' referenced in template event."));
                }
            }
        }
    }

    private void checkUndefinedBaseIdentifiersInBindingsAndInterpolations() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsCompScope = getTsComponentScopeByName(componentName);
            if (tsCompScope == null) continue;

            // gather ngFor local vars
            Set<String> localVars = new HashSet<>();
            for (Symbol s : tplCompScope.getSymbols().values()) {
                if (isTemplateLocalVar(s)) {
                    localVars.add(s.getName());
                }
            }

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                String rhs = null;

                if (isNgModelBinding(sym) || isPropertyBinding(sym)) {
                    rhs = extractRhsExpression(sym); //  product.name
                } else if (isInterpolation(sym)) {
                    // expression in {{}}
                    String name = sym.getName();
                    Matcher m = Pattern.compile("\\{\\{\\s*(.*?)\\s*\\}\\}").matcher(name);
                    if (m.find()) {
                        rhs = m.group(1); // product.price
                    }
                }

                if (rhs == null || rhs.isBlank()) continue;

                String base = extractBaseIdentifier(rhs); // "product"
                if (base == null) continue;

                // var ngFor
                if (localVars.contains(base)) continue;

                // if not found in TS
                if (tsCompScope.resolve(base) == null) {
                    errors.add(err(componentName, sym,
                            "Undefined identifier '" + base + "' referenced in expression '" + rhs + "'."));
                }
            }
        }
    }


    /** ngFor */
    private void checkNgForCollections() {
        for (Scope tplCompScope : getTemplateComponentScopes()) {
            String componentName = tplCompScope.getName();
            Scope tsCompScope = getTsComponentScopeByName(componentName);
            if (tsCompScope == null) continue;

            for (Symbol sym : tplCompScope.getSymbols().values()) {
                if (!isNgFor(sym)) continue;

                String expr = extractRhsExpression(sym); //  let product of products
                if (expr == null) continue;

                String[] parts = expr.split("of");
                if (parts.length == 2) {
                    String collection = parts[1].trim()
                            .replaceAll("[\"']", "") // remove qout
                            .split("\\s+")[0];       // first word
                    if (tsCompScope.resolve(collection) == null) {
                        errors.add(err(componentName, sym,
                                "Undefined collection '" + collection + "' used in *ngFor."));
                    }
                }

            }
        }
    }


    /* ======================== Error formatting ======================== */
    private String err(String componentName, Symbol sym, String msg) {
        return "[Component: " + componentName + "] " + msg + " (at: " + sym.getName() + ")";
    }
}
