package ast.ts.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a method call
 */
public class DotCall implements TsPostfix {
    private final String methodName;
    private final List<TsExpression> arguments;

    public DotCall(String methodName, List<TsExpression> arguments) {
        this.methodName = Objects.requireNonNull(methodName);
        this.arguments = arguments != null ? new ArrayList<>(arguments) : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("." + methodName + "(");
        for (int i = 0; i < arguments.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(arguments.get(i).toString());
        }
        sb.append(")");
        return sb.toString();
    }
}