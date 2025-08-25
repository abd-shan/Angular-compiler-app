package ts.expressions;

import ts.statements.TsBlock;
import  ts.statements.TsStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an arrow function
 */
public class ArrowFunction implements TsAtom {
    private final List<String> parameters;
    private final TsExpression body;
    private final TsBlock blockBody;

    public ArrowFunction(List<String> parameters, TsExpression body, TsBlock blockBody) {
        this.parameters = parameters != null ? new ArrayList<>(parameters) : new ArrayList<>();
        this.body = body;
        this.blockBody = blockBody;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(parameters.get(i));
        }
        sb.append(") => ");

        if (body != null) {
            sb.append(body.toString());
        } else if (blockBody != null) {
            sb.append(blockBody.toString());
        }

        return sb.toString();
    }
}
