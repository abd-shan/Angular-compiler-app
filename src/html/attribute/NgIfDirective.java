package html.attribute;

// ngIf Directive
public class NgIfDirective extends HtmlAttribute {
    private String expression;

    public NgIfDirective(String expression) {
        this.expression = expression != null ? expression : "";
    }

    @Override
    public String getName() {
        return "*ngIf";
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
        return "*ngIf=\"" + expression + "\"";
    }
}