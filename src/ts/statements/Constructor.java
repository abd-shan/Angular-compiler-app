package  ts.statements;

import java.util.List;

public class Constructor implements TsStatement {
    private List<TsStatement> body;

    public Constructor(List<TsStatement> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("constructor() {\n");

        for (TsStatement statement : body) {
            sb.append("  ").append(statement.toString()).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    // Getters and setters
    public List<TsStatement> getBody() { return body; }
}