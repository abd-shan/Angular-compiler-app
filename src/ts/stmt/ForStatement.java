package ts.stmt;

import ts.statements.TsBlock;
import ts.statements.TsStatement;

import java.util.Objects;

public class ForStatement implements TsStatement {
    private final String initializer;
    private final TsBlock body;

    public ForStatement(String initializer, TsBlock body) {
        this.initializer = initializer;
        this.body = Objects.requireNonNull(body);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("for (");
        sb.append(initializer != null ? initializer : "");
        sb.append(") {");
        sb.append("\n");
        sb.append(body.toString());
        sb.append("}\n");
        return sb.toString();
    }
}