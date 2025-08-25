package ts.types;

import java.util.Objects;

public class ArrayType extends GenericOrBasicType {
    private final GenericOrBasicType elementType;

    public ArrayType(GenericOrBasicType elementType) {
        this.elementType = Objects.requireNonNull(elementType);
    }

    public GenericOrBasicType getElementType() {
        return elementType;
    }

    @Override
    public String toString() {
        return elementType.toString() + "[]";
    }
}