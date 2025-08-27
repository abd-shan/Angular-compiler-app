package ast.ts.expressions;

import java.util.Objects;

/**
 * Represents a bracket access
 */
public class BracketAccessPostfix implements TsPostfix {
    private final TsExpression expression;

    public BracketAccessPostfix(TsExpression expression) {
        this.expression = Objects.requireNonNull(expression);
    }

    @Override
    public String toString() {
        return "[" + expression.toString() + "]";
    }
}