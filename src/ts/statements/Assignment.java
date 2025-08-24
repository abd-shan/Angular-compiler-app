package ts.statements;

import ts.expressions.TsExpression;

public class Assignment implements TsStatement {
    private String leftHandSide;
    private TsExpression rightHandSide;
    private boolean isThisAssignment;

    public Assignment(String leftHandSide, TsExpression rightHandSide, boolean isThisAssignment) {
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.isThisAssignment = isThisAssignment;
    }

    @Override
    public String toString() {
        String lhs = isThisAssignment ? "this." + leftHandSide : leftHandSide;
        return lhs + " = " + rightHandSide.toString() + ";";
    }

    // Getters and setters
    public String getLeftHandSide() { return leftHandSide; }
    public TsExpression getRightHandSide() { return rightHandSide; }
    public boolean isThisAssignment() { return isThisAssignment; }
}
