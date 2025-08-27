package  ast.ts.expressions;

import java.util.List;

public class FunctionCall implements TsExpression {
    private String functionName;
    private TsExpression functionExpression;
    private List<TsExpression> arguments;
    private boolean isMethodCall;

    public FunctionCall(String functionName, List<TsExpression> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
        this.isMethodCall = false;
    }

    public FunctionCall(TsExpression functionExpression, List<TsExpression> arguments, boolean isMethodCall) {
        this.functionExpression = functionExpression;
        this.arguments = arguments;
        this.isMethodCall = isMethodCall;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isMethodCall) {
            sb.append(functionExpression.toString());
        } else {
            sb.append(functionName);
        }

        sb.append("(");

        if (arguments != null && !arguments.isEmpty()) {
            boolean first = true;
            for (TsExpression arg : arguments) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(arg.toString());
                first = false;
            }
        }

        sb.append(")");
        return sb.toString();
    }

    // Getters and setters
    public String getFunctionName() { return functionName; }
    public TsExpression getFunctionExpression() { return functionExpression; }
    public List<TsExpression> getArguments() { return arguments; }
    public boolean isMethodCall() { return isMethodCall; }
}