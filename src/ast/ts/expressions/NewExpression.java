package ast.ts.expressions;

import ast.ts.types.GenericTypeParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a new expression
 */
public class NewExpression implements TsAtom {
    private final String constructor;
    private final List<GenericTypeParam> typeArguments;
    private final List<TsExpression> arguments;

    public NewExpression(String constructor, List<GenericTypeParam> typeArguments, List<TsExpression> arguments) {
        this.constructor = Objects.requireNonNull(constructor);
        this.typeArguments = typeArguments != null ? new ArrayList<>(typeArguments) : new ArrayList<>();
        this.arguments = arguments != null ? new ArrayList<>(arguments) : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("new " + constructor);

        if (!typeArguments.isEmpty()) {
            sb.append("<");
            for (int i = 0; i < typeArguments.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(typeArguments.get(i).toString());
            }
            sb.append(">");
        }

        sb.append("(");
        for (int i = 0; i < arguments.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(arguments.get(i).toString());
        }
        sb.append(")");

        return sb.toString();
    }
}

