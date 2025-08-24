package  ts.expressions;

public class UnaryExpression implements TsExpression {
    public enum Operator {
        NOT("!"),
        NEGATE("-");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    private Operator operator;
    private TsExpression operand;

    public UnaryExpression(Operator operator, TsExpression operand) {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public String toString() {
        return operator.toString() + operand.toString();
    }

    // Getters and setters
    public Operator getOperator() { return operator; }
    public TsExpression getOperand() { return operand; }
}