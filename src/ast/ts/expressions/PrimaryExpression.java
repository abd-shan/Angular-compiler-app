package ast.ts.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a primary expression
 */
public class PrimaryExpression implements TsExpression {
    private final TsAtom atom;
    private final List<TsPostfix> postfixes;

    public PrimaryExpression(TsAtom atom, List<TsPostfix> postfixes) {
        this.atom = Objects.requireNonNull(atom);
        this.postfixes = postfixes != null ? new ArrayList<>(postfixes) : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(atom.toString());
        for (TsPostfix postfix : postfixes) {
            sb.append(postfix.toString());
        }
        return sb.toString();
    }
}