package ast.ts.statements;

import ast.ts.types.TsType;

import java.util.Objects;

public class ConstructorParam {
    private final String name;
    private final String primitiveDataType;
    private final TsType type;

    public ConstructorParam(String name, String primitiveDataType, TsType type) {
        this.name = Objects.requireNonNull(name, "Parameter name cannot be null");
        this.primitiveDataType = primitiveDataType;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPrimitiveDataType() {
        return primitiveDataType;
    }

    public TsType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (primitiveDataType != null) {
            sb.append(primitiveDataType).append(" ");
        }

        sb.append(name);

        if (type != null) {
            sb.append(": ").append(type.toString());
        }

        return sb.toString();
    }
}