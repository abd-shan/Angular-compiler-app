package helper;

import ast.ts.statements.TsStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TsStatementBlock implements TsStatement {
    private final List<TsStatement> statements;

    public TsStatementBlock(List<TsStatement> statements) {
        this.statements = statements != null ? new ArrayList<>(statements) : new ArrayList<>();
    }

    public List<TsStatement> getStatements() {
        return Collections.unmodifiableList(statements);
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