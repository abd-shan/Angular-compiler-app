package  ts.expressions;

import java.util.List;

public class ArrayLiteral implements TsExpression {
    private List<TsExpression> elements;

    public ArrayLiteral(List<TsExpression> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (elements != null && !elements.isEmpty()) {
            boolean first = true;
            for (TsExpression element : elements) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(element.toString());
                first = false;
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // Getters and setters
    public List<TsExpression> getElements() { return elements; }
}