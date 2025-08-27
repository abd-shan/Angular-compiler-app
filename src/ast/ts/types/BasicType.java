package ast.ts.types;

public class BasicType extends GenericOrBasicType {
    public enum Primitive {
        NUMBER, STRING, BOOLEAN, ANY, NULL, UNDEFINED, CUSTOM
    }

    private final Primitive type;
    private final String customTypeName;

    // Constructor for primitive types
    public BasicType(Primitive type) {
        this.type = type;
        this.customTypeName = null;
    }

    // Constructor for custom types (ID)
    public BasicType(String customTypeName) {
        this.type = Primitive.CUSTOM;
        this.customTypeName = customTypeName;
    }

    public Primitive getType() {
        return type;
    }

    public String getCustomTypeName() {
        return customTypeName;
    }

    @Override
    public String toString() {
        return switch (type) {
            case NUMBER -> "number";
            case STRING -> "string";
            case BOOLEAN -> "boolean";
            case ANY -> "any";
            case NULL -> "null";
            case UNDEFINED -> "undefined";
            case CUSTOM -> customTypeName;
            default -> "any";
        };
    }
}