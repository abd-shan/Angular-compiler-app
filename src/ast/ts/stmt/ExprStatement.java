package ast.ts.stmt;

import ast.ts.expressions.TsExpression;
import ast.ts.statements.TsStatement;

import java.util.Objects;

/**
 * Represents an expression statement
 */
public class ExprStatement implements TsStatement {
    private final TsExpression expression;

    public ExprStatement(TsExpression expression) {
        this.expression = Objects.requireNonNull(expression);
    }


    public TsExpression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString() + ";";
    }
}