package ts.types;

public class TypeReference implements Type {
    private String typeName;

    public TypeReference(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    // Getters and setters
    public String getTypeName() { return typeName; }
}