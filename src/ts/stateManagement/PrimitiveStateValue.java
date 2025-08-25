package ts.stateManagement;

import java.util.Objects;

/**
 * PrimitiveStateValue - يمثل قيمة بدائية (سلسلة، رقم، معرف، أو null)
 */
public class PrimitiveStateValue implements StateValue {
    private final String value;
    private final ValueType type;

    public PrimitiveStateValue(String value, ValueType type) {
        this.value = value;
        this.type = Objects.requireNonNull(type, "Value type cannot be null");
    }

    public static PrimitiveStateValue fromString(String value) {
        return new PrimitiveStateValue(value, ValueType.STRING);
    }

    public static PrimitiveStateValue fromNumber(String value) {
        return new PrimitiveStateValue(value, ValueType.NUMBER);
    }

    public static PrimitiveStateValue fromIdentifier(String value) {
        return new PrimitiveStateValue(value, ValueType.IDENTIFIER);
    }

    public static PrimitiveStateValue nullValue() {
        return new PrimitiveStateValue("null", ValueType.NULL);
    }

    public static PrimitiveStateValue fromBoolean(boolean value) {
        return new PrimitiveStateValue(String.valueOf(value), ValueType.BOOLEAN);
    }

    @Override
    public ValueType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public String toCodeString() {
        if (type == ValueType.STRING) {
            return "\"" + value.replace("\"", "\\\"") + "\"";
        }
        return value;
    }
}