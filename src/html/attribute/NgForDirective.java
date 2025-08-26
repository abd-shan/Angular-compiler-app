package html.attribute;

// ngFor Directive
public class NgForDirective extends HtmlAttribute {
    private String expression;

    public NgForDirective(String expression) {
        this.expression = expression != null ? expression : "";
    }

    @Override
    public String getName() {
        return "*ngFor";
    }

    @Override
    public String getValue() {
        return expression;
    }

    public String getExpression() {
        return expression;
    }



    @Override
    public String toString() {
        return "*ngFor=\"" + expression + "\"";
    }
}