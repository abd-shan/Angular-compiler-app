package ast.ts.expressions;

import java.util.Objects;

/**
 * Represents an identifier reference
 */
public class StoredID implements TsAtom {
    private final String name;

    public StoredID(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String toString() {
        return name;
    }
}