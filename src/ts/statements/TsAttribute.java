package ts.statements;

import ts.types.TsType;

import java.util.Objects;

public abstract class TsAttribute implements TsStatement {
    protected final String name;
    protected final String primitiveDataType;
    protected final TsType type;
    protected final boolean isReadonly;

    public TsAttribute(String name, String primitiveDataType, TsType type, boolean isReadonly) {
        this.name = Objects.requireNonNull(name, "Attribute name cannot be null");
        this.primitiveDataType = primitiveDataType;
        this.type = type;
        this.isReadonly = isReadonly;
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

    public boolean isReadonly() {
        return isReadonly;
    }


}