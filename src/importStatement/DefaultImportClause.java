package importStatement;

import java.util.Objects;

public class DefaultImportClause extends ImportClause {
    private final String defaultImport;
    private final NamespaceImport namespaceImport;
    private final NamedImports namedImports;

    public DefaultImportClause(String defaultImport, NamespaceImport namespaceImport, NamedImports namedImports) {
        this.defaultImport = Objects.requireNonNull(defaultImport);
        this.namespaceImport = namespaceImport;
        this.namedImports = namedImports;
    }

    public String getDefaultImport() { return defaultImport; }
    public NamespaceImport getNamespaceImport() { return namespaceImport; }
    public NamedImports getNamedImports() { return namedImports; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(defaultImport);
        if (namespaceImport != null) {
            sb.append(", ").append(namespaceImport);
        } else if (namedImports != null) {
            sb.append(", ").append(namedImports);
        }
        return sb.toString();
    }
}