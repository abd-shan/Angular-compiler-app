package ts.stmt;

import ts.expressions.TsExpression;
import ts.statements.TsBlock;
import ts.statements.TsStatement;

import java.util.Objects;

public class IfStatement implements TsStatement {
    private final TsExpression condition;
    private final TsBlock body;

    public IfStatement(TsExpression condition, TsBlock body) {
        this.condition = condition;
        this.body = Objects.requireNonNull(body);
    }

    @Override
    public String toString() {
        return "if (" + (condition != null ? condition.toString() : "") + ") " + body.toString();
    }
}
