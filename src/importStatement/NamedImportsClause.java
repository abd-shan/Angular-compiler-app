package importStatement;

import java.util.Objects;

public class NamedImportsClause extends ImportClause {
    private final NamedImports namedImports;

    public NamedImportsClause(NamedImports namedImports) {
        this.namedImports = Objects.requireNonNull(namedImports);
    }

    public NamedImports getNamedImports() { return namedImports; }

    @Override
    public String toString() {
        return namedImports.toString();
    }
}