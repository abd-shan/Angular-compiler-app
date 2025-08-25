package importStatement;

import java.util.Objects;

public class ImportSpecifier {
    private final String imported;
    private final String alias;

    public ImportSpecifier(String imported, String alias) {
        this.imported = Objects.requireNonNull(imported);
        this.alias = alias;
    }

    public String getImported() { return imported; }
    public String getAlias() { return alias; }

    @Override
    public String toString() {
        return alias != null ? imported + " as " + alias : imported;
    }
}