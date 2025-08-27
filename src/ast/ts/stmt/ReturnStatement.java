package ast.ts.stmt;

import ast.ts.expressions.TsExpression;
import ast.ts.statements.TsStatement;

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