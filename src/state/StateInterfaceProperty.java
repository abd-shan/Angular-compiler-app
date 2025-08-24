package state;

import ts.types.TsType;

import java.util.Objects;

public class StateInterfaceProperty {
    private final String name;
    private final TsType type;

    public StateInterfaceProperty(String name, TsType type) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
    }

    public String getName() {
        return name;
    }

    public TsType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + ": " + type;
    }
}