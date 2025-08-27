package ast.ts.statements;

import java.util.Objects;

public class MethodParam {
    private final String name;
    private final ParamType type;
    private final boolean isOptional;

    public MethodParam(String name, ParamType type, boolean isOptional) {
        this.name = Objects.requireNonNull(name, "Parameter name cannot be null");
        this.type = type;
        this.isOptional = isOptional;
    }

    public String getName() {
        return name;
    }

    public ParamType getType() {
        return type;
    }

    public boolean isOptional() {
        return isOptional;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);

        if (isOptional) {
            sb.append("?");
        }

        if (type != null) {
            sb.append(": ").append(type.toString());
        }

        return sb.toString();
    }
}