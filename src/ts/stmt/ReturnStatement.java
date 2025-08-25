package ts.stmt;

import ts.expressions.TsExpression;
import ts.statements.TsStatement;

/**
 * Represents a return statement
 */
public class ReturnStatement implements TsStatement {
    private final TsExpression expression;

    public ReturnStatement(TsExpression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "return" + (expression != null ? " " + expression.toString() : "") + ";";
    }
}