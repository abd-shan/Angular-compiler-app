package ast.ts.expressions;

/**
 * Represents a 'this' reference
 */

public class ThisRef implements TsAtom {
    @Override
    public String toString() {
        return "this";
    }
}