package ts.expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a function call
 */
public class CallPostfix implements TsPostfix {
    private final boolean hasSpread;
    private final List<TsExpression> arguments;

    public CallPostfix(boolean hasSpread, List<TsExpression> arguments) {
        this.hasSpread = hasSpread;
        this.arguments = arguments != null ? new ArrayList<>(arguments) : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        if (hasSpread) {
            sb.append("...");
        }
        for (int i = 0; i < arguments.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(arguments.get(i).toString());
        }
        sb.append(")");
        return sb.toString();
    }
}