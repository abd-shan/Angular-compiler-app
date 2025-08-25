package ts.types;

import java.util.Objects;

public class StringGenericParam extends GenericTypeParam {
    private final String value;

    public StringGenericParam(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
