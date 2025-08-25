package ts.expressions;

import java.util.Objects;

/**
 * Represents a numeric literal
 */
public class NumberLiteral implements TsAtom {
    private final String value;

    public NumberLiteral(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String toString() {
        return value;
    }
}