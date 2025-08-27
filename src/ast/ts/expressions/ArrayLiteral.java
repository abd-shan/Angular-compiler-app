package  ast.ts.expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an array literal
 */
public class ArrayLiteral implements TsAtom {
    private final List<SpreadOrExpr> elements;

    public ArrayLiteral(List<SpreadOrExpr> elements) {
        this.elements = elements != null ? new ArrayList<>(elements) : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < elements.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }
}