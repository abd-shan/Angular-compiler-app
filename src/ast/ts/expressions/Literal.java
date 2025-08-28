package  ast.ts.expressions;

public class Literal implements TsExpression {
    public enum Type {
        STRING,
        NUMBER,
        BOOLEAN,
        NULL, KEYVALUE,

    }

    private Type type;
    private Object value;

    public Literal(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        if (type == Type.STRING) {
            return "\"" + value.toString() + "\"";
        } else if (type == Type.NULL) {
            return "null";
        }
        return value.toString();
    }

    // Getters and setters
    public Type getType() { return type; }
    public Object getValue() { return value; }
}