package importStatement;

import java.util.Objects;

public class NamespaceImport {
    private final String namespaceName;

    public NamespaceImport(String namespaceName) {
        this.namespaceName = Objects.requireNonNull(namespaceName);
    }

    public String getNamespaceName() { return namespaceName; }

    @Override
    public String toString() {
        return "* as " + namespaceName;
    }
}

