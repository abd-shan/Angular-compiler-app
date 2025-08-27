package ast.importStatement;

import java.util.Objects;


public class NamespaceImportClause extends ImportClause {
    private final NamespaceImport namespaceImport;

    public NamespaceImportClause(NamespaceImport namespaceImport) {
        this.namespaceImport = Objects.requireNonNull(namespaceImport);
    }

    public NamespaceImport getNamespaceImport() {
        return namespaceImport;
    }

    @Override
    public String toString() {
        return namespaceImport.toString();
    }
}
