package ts.statements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TsBlock {
    private final List<TsStatement> statements;

    public TsBlock(List<TsStatement> statements) {
        this.statements = statements != null ? new ArrayList<>(statements) : new ArrayList<>();
    }

    public List<TsStatement> getStatements() {
        return Collections.unmodifiableList(statements);
    }

    public void addStatement(TsStatement statement) {
        if (statement != null) {
            statements.add(statement);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TsStatement statement : statements) {
            sb.append(statement.toString()).append("\n");
        }
        return sb.toString();
    }
}