package ts.types;

public class ArrayType implements Type {
    private Type elementType;

    public ArrayType(Type elementType) {
        this.elementType = elementType;
    }

    @Override
    public String toString() {
        return elementType.toString() + "[]";
    }

    // Getters and setters
    public Type getElementType() { return elementType; }
}
