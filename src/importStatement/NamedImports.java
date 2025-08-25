package importStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NamedImports {
    private final List<ImportSpecifier> specifiers;

    public NamedImports(List<ImportSpecifier> specifiers) {
        this.specifiers = specifiers != null ? new ArrayList<>(specifiers) : new ArrayList<>();
    }

    public List<ImportSpecifier> getSpecifiers() {
        return Collections.unmodifiableList(specifiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < specifiers.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(specifiers.get(i));
        }
        sb.append("}");
        return sb.toString();
    }
}
