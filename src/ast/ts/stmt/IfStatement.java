package ast.ts.stmt;

import ast.ts.expressions.TsExpression;
import ast.ts.statements.TsBlock;
import ast.ts.statements.TsStatement;

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
        StringBuilder sb = new StringBuilder();
        sb.append("if (");
        sb.append(condition != null ? condition.toString() : "");
        sb.append(") {");
        sb.append("\n");
        sb.append(body.toString());
        sb.append("}\n");
        return sb.toString();
    }
}
