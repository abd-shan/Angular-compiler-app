package ts.expressions;

import java.util.Objects;

/**
 * Represents a key-value pair in an object literal
 */
public class KeyValuePair {
    private final String key;
    private final TsExpression value;
    private final boolean isSpread;

    public KeyValuePair(String key, TsExpression value, boolean isSpread) {
        this.key = key;
        this.value = Objects.requireNonNull(value);
        this.isSpread = isSpread;
    }

    @Override
    public String toString() {
        if (isSpread) {
            return "..." + value.toString();
        } else {
            return key + ": " + value.toString();
        }
    }
}