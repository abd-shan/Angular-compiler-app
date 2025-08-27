package  ast.ts.expressions;

import java.util.Objects;

/**
 * Represents a unary expression
 */
public class UnaryExpression implements TsExpression {
    private final String operator;
    private final TsExpression expression;
    private final boolean isPrefix;

    public UnaryExpression(String operator, TsExpression expression, boolean isPrefix) {
        this.operator = Objects.requireNonNull(operator);
        this.expression = Objects.requireNonNull(expression);
        this.isPrefix = isPrefix;
    }

    @Override
    public String toString() {
        if (isPrefix) {
            return operator + expression.toString();
        } else {
            return expression.toString() + operator;
        }
    }
}