package ts.stmt;

import ts.expressions.TsExpression;
import ts.statements.TsStatement;

import java.util.Objects;

/**
 * Represents an expression statement
 */
public class ExprStatement implements TsStatement {
    private final TsExpression expression;

    public ExprStatement(TsExpression expression) {
        this.expression = Objects.requireNonNull(expression);
    }

    @Override
    public String toString() {
        return expression.toString() + ";";
    }
}