package ts.types;

import java.util.Objects;

public class TypeGenericParam extends GenericTypeParam {
    private final GenericOrBasicType type;

    public TypeGenericParam(GenericOrBasicType type) {
        this.type = Objects.requireNonNull(type);
    }

    public GenericOrBasicType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
