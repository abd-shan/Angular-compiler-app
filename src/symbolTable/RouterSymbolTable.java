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
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Set<String>> e : pathToComponents.entrySet()) {
            sb.append(e.getKey()).append(" -> ");
            boolean first = true;
            for (String comp : e.getValue()) {
                if (!first) sb.append(", ");
                sb.append(comp);
                first = false;
            }
            sb.append('\n');
        }
        return sb.toString();
    }
} 