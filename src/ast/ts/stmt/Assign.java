package ast.ts.stmt;

import ast.ts.expressions.LeftHandSide;
import ast.ts.expressions.TsExpression;
import ast.ts.statements.TsStatement;

import java.util.Objects;

public class Assign implements TsStatement {
    private final LeftHandSide leftHandSide;
    private final TsExpression expression;

    public Assign(LeftHandSide leftHandSide, TsExpression expression) {
        this.leftHandSide = Objects.requireNonNull(leftHandSide);
        this.expression = Objects.requireNonNull(expression);
    }

    public LeftHandSide getLeftHandSide() {
        return leftHandSide;
    }

    public TsExpression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return leftHandSide.toString() + " = " + expression.toString() + ";";
    }
}
