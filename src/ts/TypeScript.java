package ts;


import ts.statements.TsStatement;

import java.util.ArrayList;
import java.util.List;

public class TypeScript {
    private List<TsStatement> statements;

    public TypeScript() {
        this.statements = new ArrayList<>();
    }

    public TypeScript(List<TsStatement> statements) {
        this.statements = statements;
    }

    public void addStatement(TsStatement statement) {
        this.statements.add(statement);
    }

    public List<TsStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<TsStatement> statements) {
        this.statements = statements;
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