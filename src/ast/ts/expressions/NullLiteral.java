package ast.ts.expressions;

/**
 * Represents a null literal
 */
public class NullLiteral implements TsAtom {
    @Override
    public String toString() {
        return "null";
    }
}