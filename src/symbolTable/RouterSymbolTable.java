package symbolTable;

import java.util.*;

public class RouterSymbolTable {
    private final Map<String, Set<String>> pathToComponents = new LinkedHashMap<>();

    public void addRoute(String path, String componentName) {
        if (path == null || path.isBlank() || componentName == null || componentName.isBlank()) return;
        pathToComponents.computeIfAbsent(path, k -> new LinkedHashSet<>()).add(componentName);
    }

    public Map<String, Set<String>> getRoutes() {
        return Collections.unmodifiableMap(pathToComponents);
    }

    @Override
    public String toString() {
        if (pathToComponents.isEmpty()) {
            return "(empty)";
        }

        // Collect data into rows
        java.util.List<String[]> rows = new java.util.ArrayList<>();
        for (Map.Entry<String, Set<String>> e : pathToComponents.entrySet()) {
            String path = e.getKey();
            String components = String.join(", ", e.getValue());
            rows.add(new String[]{path, components});
        }

        // Compute column widths (include headers in width calculation)
        int pathWidth = "Path".length();
        int compWidth = "Components".length();
        for (String[] row : rows) {
            if (row[0].length() > pathWidth) pathWidth = row[0].length();
            if (row[1].length() > compWidth) compWidth = row[1].length();
        }
        int[] widths = new int[]{pathWidth, compWidth};

        // Build the table
        StringBuilder sb = new StringBuilder();
        appendSeparator(sb, widths);
        appendRow(sb, widths, "Path", "Components");
        appendSeparator(sb, widths);
        for (String[] row : rows) {
            appendRow(sb, widths, row[0], row[1]);
        }
        appendSeparator(sb, widths);
        return sb.toString();
    }

    // Helper method to append a separator line
    private void appendSeparator(StringBuilder sb, int[] widths) {
        sb.append("+");
        for (int w : widths) {
            sb.append("-".repeat(w + 2)).append("+");
        }
        sb.append("\n");
    }

    // Helper method to append a row with aligned columns
    private void appendRow(StringBuilder sb, int[] widths, String... columns) {
        sb.append("|");
        for (int i = 0; i < columns.length; i++) {
            String format = " %-" + widths[i] + "s ";
            sb.append(String.format(format, columns[i])).append("|");
        }
        sb.append("\n");
    }
} 