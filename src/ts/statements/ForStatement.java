package  ts.statements;

import  ts.expressions.TsExpression;
import java.util.List;

public class ForStatement implements TsStatement {
    private String loopVariable;
    private TsExpression iterable;
    private List<TsStatement> body;

    public ForStatement(String loopVariable, TsExpression iterable, List<TsStatement> body) {
        this.loopVariable = loopVariable;
        this.iterable = iterable;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("for (let ").append(loopVariable).append(" of ").append(iterable.toString()).append(") {\n");

        for (TsStatement statement : body) {
            sb.append("  ").append(statement.toString()).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }

    // Getters and setters
    public String getLoopVariable() { return loopVariable; }
    public TsExpression getIterable() { return iterable; }
    public List<TsStatement> getBody() { return body; }
}