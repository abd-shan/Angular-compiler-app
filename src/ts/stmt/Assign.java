package ts.stmt;

import ts.expressions.LeftHandSide;
import ts.expressions.TsExpression;
import ts.statements.TsStatement;

import java.util.Objects;

public class Assign implements TsStatement {
    private final LeftHandSide leftHandSide;
    private final TsExpression expression;

    public Assign(LeftHandSide leftHandSide, TsExpression expression) {
        this.leftHandSide = Objects.requireNonNull(leftHandSide);
        this.expression = Objects.requireNonNull(expression);
    }

    @Override
    public String toString() {
        return leftHandSide.toString() + " = " + expression.toString() + ";";
    }
}
