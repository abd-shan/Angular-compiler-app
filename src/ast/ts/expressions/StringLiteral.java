package ast.ts.expressions;

import java.util.Objects;

/**
 * Represents a string literal
 */
public class StringLiteral implements TsAtom {
    private final String value;

    public StringLiteral(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\"" + value.replace("\"", "\\\"") + "\"";
    }
}