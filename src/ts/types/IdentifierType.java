package ts.types;



public class IdentifierType extends TsType {
    private final String name;

    public IdentifierType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
