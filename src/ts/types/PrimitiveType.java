package ts.types;

public class PrimitiveType implements Type {
    public enum Primitive {
        NUMBER("number"),
        STRING("string"),
        BOOLEAN("boolean"),
        ANY("any"),
        VOID("void");

        private final String name;

        Primitive(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private Primitive type;

    public PrimitiveType(Primitive type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    // Getters and setters
    public Primitive getType() { return type; }
}
