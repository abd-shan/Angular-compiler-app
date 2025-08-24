package html.element;

import html.HtmlNode;

public class Interpolation implements HtmlNode {
    private String expression; // المحتوى داخل {{ }}

    public Interpolation(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

}
