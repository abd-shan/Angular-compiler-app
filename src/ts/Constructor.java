package ts;

import ts.expressions.Expression;

import java.util.ArrayList;

public class Constructor {

    ArrayList<Expression> expressions;

    public Constructor() {
        expressions = new ArrayList<>();
    }

    public void addExpression(Expression e) {
        expressions.add(e);
    }

    @Override
    public String toString() {
        return expressions.toString();
    }
}
