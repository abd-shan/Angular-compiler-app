package ast.ts.expressions;

import java.util.Objects;

/**
 * Represents a key-value pair in an object literal
 */
public class KeyValuePair  {
    private final String key;
    private final TsExpression value;

    public KeyValuePair(String key, TsExpression value) {
        this.key = key;
        this.value = Objects.requireNonNull(value);
    }

    public String getKey() {
        return key;
    }

    public TsExpression getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + ": " + value.toString();
    }

}