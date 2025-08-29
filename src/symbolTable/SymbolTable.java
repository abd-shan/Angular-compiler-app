package symbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    private Scope currentScope;

    public void enterScope(String name) {
        Scope child = new Scope(name, currentScope);
        if (currentScope != null) {
            currentScope.addChild(child);
        }
        currentScope = child;
    }

    public void exitScope() {
        if (currentScope != null) {
            currentScope = currentScope.getParent();
        }
    }

    public void define(String name, String type) {
        define(name, type, -1, -1);
    }

    public void define(String name, String type, int line, int column) {
        currentScope.define(new Symbol(name, type, line, column));
    }

    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    public Scope getCurrentScope() {
        return currentScope;
    }


    private static String buildScopePath(Scope scope) {
        if (scope == null) return "";
        StringBuilder path = new StringBuilder();
        buildPathReversed(scope, path);
        return path.toString();
    }

    private static void buildPathReversed(Scope scope, StringBuilder out) {
        if (scope == null) return;
        buildPathReversed(scope.getParent(), out);
        if (out.length() > 0) out.append(" > ");
        out.append(scope.getName());
    }

    private static void collectRows(List<String[]> rows, Scope scope) {
        if (scope == null) return;
        String path = buildScopePath(scope);
        Map<String, Symbol> symbols = scope.getSymbols();

        if (symbols.isEmpty()) {
            rows.add(new String[] { path, "", "", "", "" });
        } else {
            for (Symbol sym : symbols.values()) {
                rows.add(new String[] {
                        path,
                        sym.getName(),
                        sym.getType(),
                        sym.getLine() != -1 ? String.valueOf(sym.getLine()) : "",
                        sym.getColumn() != -1 ? String.valueOf(sym.getColumn()) : ""
                });
            }
        }
        for (Scope child : scope.getChildren()) {
            collectRows(rows, child);
        }
    }

    private static int[] computeColumnWidths(List<String[]> rows) {
        int[] widths = new int[] { "Scope".length(), "Name".length(), "Type".length(), "Line".length(), "Column".length() };
        for (String[] r : rows) {
            for (int i = 0; i < r.length; i++) {
                if (r[i] != null) {
                    widths[i] = Math.max(widths[i], r[i].length());
                }
            }
        }
        return widths;
    }

    private static String padRight(String s, int width) {
        if (s == null) s = "";
        if (s.length() >= width) return s;
        StringBuilder sb = new StringBuilder(width);
        sb.append(s);
        for (int i = s.length(); i < width; i++) sb.append(' ');
        return sb.toString();
    }

    private static void appendSeparator(StringBuilder sb, int[] widths) {
        sb.append('+');
        for (int w : widths) {
            for (int i = 0; i < w + 2; i++) sb.append('-');
            sb.append('+');
        }
        sb.append('\n');
    }

    private static void appendRow(StringBuilder sb, int[] widths, String... columns) {
        sb.append('|');
        for (int i = 0; i < columns.length; i++) {
            sb.append(' ').append(padRight(columns[i], widths[i])).append(' ').append('|');
        }
        sb.append('\n');
    }

    @Override
    public String toString() {
        // Find root
        Scope root = currentScope;
        while (root != null && root.getParent() != null) {
            root = root.getParent();
        }
        if (root == null) return "(empty symbol table)";

        List<String[]> rows = new ArrayList<>();
        collectRows(rows, root);
        int[] widths = computeColumnWidths(rows);

        StringBuilder sb = new StringBuilder();
        appendSeparator(sb, widths);
        appendRow(sb, widths, "Scope", "Name", "Type", "Line", "Column");
        appendSeparator(sb, widths);
        for (String[] r : rows) {
            appendRow(sb, widths, r[0], r[1], r[2], r[3], r[4]);
        }
        appendSeparator(sb, widths);
        return sb.toString();
    }
}