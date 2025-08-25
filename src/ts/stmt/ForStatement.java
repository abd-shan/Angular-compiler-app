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
        return "for (" + (initializer != null ? initializer : "") + ") " + body.toString();
    }
}