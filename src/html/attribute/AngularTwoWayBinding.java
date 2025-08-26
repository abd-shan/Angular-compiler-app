package html.attribute;

// Two-way Binding
public class AngularTwoWayBinding extends HtmlAttribute {
    private String property;
    private String expression;

    public AngularTwoWayBinding(String property, String expression) {
        this.property = property != null ? property : "";
        this.expression = expression != null ? expression : "";
    }

    @Override
    public String getName() {
        return "[(" + property + ")]";
    }

    @Override
    public String getValue() {
        return expression;
    }

    public String getProperty() {
        return property;
    }

    public String getExpression() {
        return expression;
    }


    @Override
    public String toString() {
        return "[(" + property + ")]=\"" + expression + "\"";
    }
}
