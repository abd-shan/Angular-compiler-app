package  ts.statements;

import  ts.modifiers.Modifier;
import ts.types.TsType;

import java.util.*;

public class Method implements TsStatement {
    private final String name;
    private final String primitiveDataType;
    private final List<MethodParam> parameters;
    private final TsType returnType;
    private final TsBlock body;

    public Method(String name, String primitiveDataType, List<MethodParam> parameters, TsType returnType, TsBlock body) {
        this.name = Objects.requireNonNull(name, "Method name cannot be null");
        this.primitiveDataType = primitiveDataType;
        this.parameters = parameters != null ? new ArrayList<>(parameters) : new ArrayList<>();
        this.returnType = returnType;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public String getPrimitiveDataType() {
        return primitiveDataType;
    }

    public List<MethodParam> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    public TsType getReturnType() {
        return returnType;
    }

    public TsBlock getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (primitiveDataType != null) {
            sb.append(primitiveDataType).append(" ");
        }

        sb.append(name).append("(");

        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(parameters.get(i).toString());
        }

        sb.append(")");

        if (returnType != null) {
            sb.append(": ").append(returnType.toString());
        }

        sb.append(" {\n");

        if (body != null) {
            sb.append(body.toString()).append("\n");
        }

        sb.append("}");

        return sb.toString();
    }
}