package  ts.statements;

import  ts.modifiers.Modifier;
import  ts.types.Type;
import java.util.List;
import java.util.Map;

public class Method implements TsStatement {
    private String methodName;
    private List<Modifier> modifiers;
    private Map<String, Type> parameters;
    private Type returnType;
    private List<TsStatement> body;
    private boolean isVoid;

    public Method(String methodName, List<Modifier> modifiers, Map<String, Type> parameters,
                  Type returnType, List<TsStatement> body, boolean isVoid) {
        this.methodName = methodName;
        this.modifiers = modifiers;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
        this.isVoid = isVoid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // modifiers
        if (modifiers != null) {
            for (Modifier modifier : modifiers) {
                sb.append(modifier.toString()).append(" ");
            }
        }

        // method name
        sb.append(methodName).append("(");

        // parameters
        if (parameters != null && !parameters.isEmpty()) {
            boolean first = true;
            for (Map.Entry<String, Type> param : parameters.entrySet()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(param.getKey()).append(": ").append(param.getValue().toString());
                first = false;
            }
        }

        sb.append(")");

        // return type
        if (returnType != null) {
            sb.append(": ").append(returnType.toString());
        } else if (isVoid) {
            sb.append(": void");
        }

        sb.append(" {\n");

        // body
        if (body != null) {
            for (TsStatement statement : body) {
                sb.append("  ").append(statement.toString()).append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    // Getters and setters
    public String getMethodName() { return methodName; }
    public List<Modifier> getModifiers() { return modifiers; }
    public Map<String, Type> getParameters() { return parameters; }
    public Type getReturnType() { return returnType; }
    public List<TsStatement> getBody() { return body; }
    public boolean isVoid() { return isVoid; }
}