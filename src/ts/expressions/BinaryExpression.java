package  ts.expressions;

public class BinaryExpression implements TsExpression {
    public enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        EQUALS("=="),
        STRICT_EQUALS("==="),
        NOT_EQUALS("!="),
        STRICT_NOT_EQUALS("!=="),
        LESS_THAN("<"),
        GREATER_THAN(">"),
        LESS_THAN_EQUAL("<="),
        GREATER_THAN_EQUAL(">="),
        AND("&&"),
        OR("||");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    private TsExpression left;
    private Operator operator;
    private TsExpression right;

    public BinaryExpression(TsExpression left, Operator operator, TsExpression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " " + operator.toString() + " " + right.toString();
    }

    // Getters and setters
    public TsExpression getLeft() { return left; }
    public Operator getOperator() { return operator; }
    public TsExpression getRight() { return right; }
}