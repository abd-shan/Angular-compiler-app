package ts.expressions;

import  ts.statements.TsStatement;
import java.util.List;

public class ArrowFunction implements TsExpression {
    private List<String> parameters;
    private TsExpression expressionBody;
    private List<TsStatement> statementBody;
    private boolean hasBraces;

    public ArrowFunction(List<String> parameters, TsExpression expressionBody) {
        this.parameters = parameters;
        this.expressionBody = expressionBody;
        this.hasBraces = false;
    }

    public ArrowFunction(List<String> parameters, List<TsStatement> statementBody) {
        this.parameters = parameters;
        this.statementBody = statementBody;
        this.hasBraces = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        if (parameters != null && !parameters.isEmpty()) {
            boolean first = true;
            for (String param : parameters) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(param);
                first = false;
            }
        }

        sb.append(") => ");

        if (hasBraces) {
            sb.append("{\n");
            for (TsStatement statement : statementBody) {
                sb.append("  ").append(statement.toString()).append("\n");
            }
            sb.append("}");
        } else {
            sb.append(expressionBody.toString());
        }

        return sb.toString();
    }

    // Getters and setters
    public List<String> getParameters() { return parameters; }
    public TsExpression getExpressionBody() { return expressionBody; }
    public List<TsStatement> getStatementBody() { return statementBody; }
    public boolean hasBraces() { return hasBraces; }
}