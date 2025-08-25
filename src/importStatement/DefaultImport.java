package importStatement;

import java.util.Objects;


public class DefaultImport {
    private final String importName;

    public DefaultImport(String importName) {
        this.importName = Objects.requireNonNull(importName);
    }

    public String getImportName() { return importName; }

    @Override
    public String toString() {
        return importName;
    }
}