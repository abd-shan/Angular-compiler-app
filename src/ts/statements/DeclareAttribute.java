package ts.statements;

import ts.types.TsType;

public class DeclareAttribute extends TsAttribute {
    public DeclareAttribute(String name, String primitiveDataType, TsType type, boolean isReadonly) {
        super(name, primitiveDataType, type, isReadonly);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (primitiveDataType != null) {
            sb.append(primitiveDataType).append(" ");
        }

        if (isReadonly) {
            sb.append("readonly ");
        }

        sb.append(name);

        if (type != null) {
            sb.append(": ").append(type.toString());
        }

        sb.append(";");

        return sb.toString();
    }
}