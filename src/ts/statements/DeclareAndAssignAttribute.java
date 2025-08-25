package ts.statements;

import ts.expressions.TsExpression;
import ts.types.TsType;

public class DeclareAndAssignAttribute extends TsAttribute {
    private final TsExpression expression;

    public DeclareAndAssignAttribute(String name, String primitiveDataType, TsType type,
                                     boolean isReadonly, TsExpression expression) {
        super(name, primitiveDataType, type, isReadonly);
        this.expression = expression;
    }

    public TsExpression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (primitiveDataType != null) {
            sb.append(primitiveDataType).append(" ");
        }

        if (isReadonly) {
            sb.append("readonly ");
        }

        sb.append(name);

        if (type != null) {
            sb.append(": ").append(type.toString());
        }

        if (expression != null) {
            sb.append(" = ").append(expression.toString());
        }

        sb.append(";");
        sb.append('\n');

        return sb.toString();
    }
}