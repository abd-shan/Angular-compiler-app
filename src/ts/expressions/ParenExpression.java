package ts.expressions;

import java.util.Objects;

/**
 * Represents a parenthesized expression
 */
public class ParenExpression implements TsAtom {
    private final TsExpression expression;

    public ParenExpression(TsExpression expression) {
        this.expression = Objects.requireNonNull(expression);
    }

    @Override
    public String toString() {
        return "(" + expression.toString() + ")";
    }
}