package ast.ts.statements;

import ast.ts.types.TsType;

public class ParamType {
    private final TsType type;
    private final boolean isEvent;

    public ParamType(TsType type, boolean isEvent) {
        this.type = type;
        this.isEvent = isEvent;
    }

    public TsType getType() {
        return type;
    }

    public boolean isEvent() {
        return isEvent;
    }

    @Override
    public String toString() {
        if (isEvent) {
            return "Event";
        }

        return type != null ? type.toString() : "any";
    }
}