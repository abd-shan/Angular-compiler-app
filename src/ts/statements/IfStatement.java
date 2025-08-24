package ts.statements;

import  ts.expressions.TsExpression;
import java.util.List;

public class IfStatement implements TsStatement {
    private TsExpression condition;
    private List<TsStatement> thenBlock;
    private List<TsStatement> elseBlock; // optional

    public IfStatement(TsExpression condition, List<TsStatement> thenBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
    }

    public IfStatement(TsExpression condition, List<TsStatement> thenBlock, List<TsStatement> elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(condition.toString()).append(") {\n");

        for (TsStatement statement : thenBlock) {
            sb.append("  ").append(statement.toString()).append("\n");
        }
        sb.append("}");

        if (elseBlock != null && !elseBlock.isEmpty()) {
            sb.append(" else {\n");
            for (TsStatement statement : elseBlock) {
                sb.append("  ").append(statement.toString()).append("\n");
            }
            sb.append("}");
        }

        return sb.toString();
    }

    // Getters and setters
    public TsExpression getCondition() { return condition; }
    public List<TsStatement> getThenBlock() { return thenBlock; }
    public List<TsStatement> getElseBlock() { return elseBlock; }
}