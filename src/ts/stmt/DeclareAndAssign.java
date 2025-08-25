package ts.stmt;

import ts.expressions.TsExpression;
import ts.statements.TsStatement;
import ts.types.TsType;

import java.util.Objects;

public class DeclareAndAssign implements TsStatement {
    private final String keyword;
    private final String name;
    private final TsType type;
    private final TsExpression expression;

    public DeclareAndAssign(String keyword, String name, TsType type, TsExpression expression) {
        this.keyword = Objects.requireNonNull(keyword);
        this.name = Objects.requireNonNull(name);
        this.type = type;
        this.expression = Objects.requireNonNull(expression);
    }

    @Override
    public String toString() {
        return keyword + " " + name + (type != null ? ": " + type.toString() : "") +
                " = " + expression.toString() + ";";
    }
}