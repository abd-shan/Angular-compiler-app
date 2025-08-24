package  ts.expressions;

public class TernaryExpression implements TsExpression {
    private TsExpression condition;
    private TsExpression thenExpression;
    private TsExpression elseExpression;

    public TernaryExpression(TsExpression condition, TsExpression thenExpression, TsExpression elseExpression) {
        this.condition = condition;
        this.thenExpression = thenExpression;
        this.elseExpression = elseExpression;
    }

    @Override
    public String toString() {
        return condition.toString() + " ? " + thenExpression.toString() + " : " + elseExpression.toString();
    }

    // Getters and setters
    public TsExpression getCondition() { return condition; }
    public TsExpression getThenExpression() { return thenExpression; }
    public TsExpression getElseExpression() { return elseExpression; }
}