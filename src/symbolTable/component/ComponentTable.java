package symbolTable.component;

import java.util.*;

public class ComponentTable {


    private final Map<String, Component> components = new HashMap<>();
    private final Set<String> importedComponents = new HashSet<>();

    public void addComponent(Component component) {
        if (components.containsKey(component.getClassName())) {
            reportError("Duplicate component class", component.getClassName(), -1);
        }
        components.put(component.getClassName(), component);
    }

    public void registerImport(String componentName) {
        importedComponents.add(componentName);
    }

    public boolean isImportedViaStatement(String name) {
        return importedComponents.contains(name);
    }

    public void registerViaStatement(String componentName) {
        importedComponents.add(componentName);

    }

    public Component getComponentByClass(String className) {
        return components.get(className);
    }

    public Component getComponentBySelector(String selector) {
        for (Component c : components.values()) {
            if (c.getSelector().equals(selector)) {
                return c;
            }
        }
        return null;
    }

    public boolean isImported(String importingClass, String importedClass) {
        Component c = components.get(importingClass);
        if (c == null) return false;
        return c.getImports().contains(importedClass) || isImportedViaStatement(importedClass);
    }

    public void validateImportUsage(String usingClass, String requiredClass, int line) {
        Component using = components.get(usingClass);
        if (using == null) {
            reportError("Using component not found", usingClass, line);
        }
        if (!components.containsKey(requiredClass)) {
            reportError("Required component not defined", requiredClass, line);
        } else if (!isImported(usingClass, requiredClass)) {
            reportError("Component '" + requiredClass + "' not imported in '" + usingClass + "'", requiredClass, line);
        }
    }

    private void reportError(String message, String context, int line) {
        if (line > 0)
            System.err.printf("Semantic Error (line %d): %s → %s%n", line, message, context);
        else
            System.err.printf("Semantic Error: %s → %s%n", message, context);
        System.exit(1);
    }

    public void printTable() {
        System.out.println("\n─────── Component Table ───────");
        for (Component c : components.values()) {
            System.out.println(c);
        }
        System.out.println("───────────────────────────────\n");
    }
}