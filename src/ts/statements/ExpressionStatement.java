package ts.statements;

import ts.expressions.TsExpression;

public class ExpressionStatement implements TsStatement {
    private TsExpression expression;

    public ExpressionStatement(TsExpression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return expression.toString() + ";";
    }

    // Getters and setters
    public TsExpression getExpression() { return expression; }
}