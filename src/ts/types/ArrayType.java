package ts.types;

public class ArrayType extends TsType {
    private final TsType elementType;

    public ArrayType(TsType elementType) {
        this.elementType = elementType;
    }

    public TsType getElementType() {
        return elementType;
    }

    @Override
    public String toString() {
        return elementType + "[]";
    }
}
