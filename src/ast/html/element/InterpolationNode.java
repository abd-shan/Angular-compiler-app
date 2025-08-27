package ast.html.element;

import ast.html.Node;

public class InterpolationNode extends Node {
    private String expression;

    public InterpolationNode(String expression) {
        this.expression = expression != null ? expression : "";
    }

    public String getExpression() {
        return expression;
    }



    @Override
    public String toString() {
        return "{{" + expression + "}}";
    }
}