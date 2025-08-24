package ts.types;

public class PrimitiveType extends TsType {


    private final Kind kind;

    public PrimitiveType(Kind kind) {
        this.kind = kind;
    }

    public Kind getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return kind.name().toLowerCase();
    }
}
