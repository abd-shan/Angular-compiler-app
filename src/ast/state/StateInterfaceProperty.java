package ast.state;

import java.util.Objects;

public class StateInterfaceProperty {
    private final String name;
    private final String type;

    public StateInterfaceProperty(String name, String type) {
        this.name = Objects.requireNonNull(name);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + ": " + type;
    }
}