package ts.expressions;

import java.util.Objects;

/**
 * Represents a spread or expression in an array literal
 */

public class SpreadOrExpr {
    private final boolean isSpread;
    private final TsExpression expression;

    public SpreadOrExpr(boolean isSpread, TsExpression expression) {
        this.isSpread = isSpread;
        this.expression = Objects.requireNonNull(expression);
    }

    @Override
    public String toString() {
        return (isSpread ? "..." : "") + expression.toString();
    }
}