package visitors;

import java.util.ArrayList;
import java.util.List;

public class Component {
    private final String className;
    private final String selector;
    private final boolean standalone;
    private final List<String> imports;
    private final List<String> staticImports;

    public Component(String className, String selector, boolean standalone, List<String> imports) {
        this.className = className;
        this.selector = selector;
        this.standalone = standalone;
        this.imports = new ArrayList<>(imports);
        this.staticImports = new ArrayList<>(imports);
    }

    public String getClassName() {
        return className;
    }

    public String getSelector() {
        return selector;
    }

    public boolean isStandalone() {
        return standalone;
    }

    public List<String> getImports() {
        return imports;
    }

    public boolean importsComponent(String componentName) {
        return imports.contains(componentName);
    }

    @Override
    public String toString() {
        return "Component{" +
                "className='" + className + '\'' +
                ", selector='" + selector + '\'' +
                ", standalone=" + standalone +
                ", imports=" + imports +
                '}';
    }
}