package ts.expressions;

import java.util.Objects;

/**
 * Represents a property access
 */
public class DotAccessPostfix implements TsPostfix {
    private final String propertyName;

    public DotAccessPostfix(String propertyName) {
        this.propertyName = Objects.requireNonNull(propertyName);
    }

    @Override
    public String toString() {
        return "." + propertyName;
    }
}