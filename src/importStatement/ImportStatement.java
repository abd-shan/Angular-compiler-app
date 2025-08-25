package importStatement;

import java.util.Objects;

public class ImportStatement {
    private final ImportClause clause;
    private final String modulePath;

    public ImportStatement(ImportClause clause, String modulePath) {
        this.clause = Objects.requireNonNull(clause);
        this.modulePath = Objects.requireNonNull(modulePath);
    }

    public ImportClause getClause() { return clause; }
    public String getModulePath() { return modulePath; }

    @Override
    public String toString() {
        return "import " + clause + " from " + modulePath;
    }
}

