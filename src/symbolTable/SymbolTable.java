package symbolTable;

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
        currentScope.define(new Symbol(name, type));
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

    private static void collectRows(java.util.List<String[]> rows, Scope scope) {
        if (scope == null) return;
        String path = buildScopePath(scope);
        java.util.Map<String, Symbol> symbols = scope.getSymbols();
        if (symbols.isEmpty()) {
            rows.add(new String[] { path, "", "" });
        } else {
            for (Symbol sym : symbols.values()) {
                rows.add(new String[] { path, sym.getName(), sym.getType() });
            }
        }
        for (Scope child : scope.getChildren()) {
            collectRows(rows, child);
        }
    }

    private static int[] computeColumnWidths(java.util.List<String[]> rows) {
        int[] widths = new int[] { "Scope".length(), "Name".length(), "Type".length() };
        for (String[] r : rows) {
            if (r[0] != null) widths[0] = Math.max(widths[0], r[0].length());
            if (r[1] != null) widths[1] = Math.max(widths[1], r[1].length());
            if (r[2] != null) widths[2] = Math.max(widths[2], r[2].length());
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

    private static void appendRow(StringBuilder sb, int[] widths, String c1, String c2, String c3) {
        sb.append('|').append(' ').append(padRight(c1, widths[0])).append(' ').append('|')
          .append(' ').append(padRight(c2, widths[1])).append(' ').append('|')
          .append(' ').append(padRight(c3, widths[2])).append(' ').append('|')
          .append('\n');
    }

    @Override
    public String toString() {
        // Find root
        Scope root = currentScope;
        while (root != null && root.getParent() != null) {
            root = root.getParent();
        }
        if (root == null) return "(empty symbol table)";

        java.util.List<String[]> rows = new java.util.ArrayList<>();
        collectRows(rows, root);
        int[] widths = computeColumnWidths(rows);

        StringBuilder sb = new StringBuilder();
        appendSeparator(sb, widths);
        appendRow(sb, widths, "Scope", "Name", "Type");
        appendSeparator(sb, widths);
        for (String[] r : rows) {
            appendRow(sb, widths, r[0], r[1], r[2]);
        }
        appendSeparator(sb, widths);
        return sb.toString();
    }
}
