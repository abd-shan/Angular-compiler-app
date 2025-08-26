package html.attribute;

// ngIf Directive

public class NgIfAttribute extends HtmlAttribute {
    private String expression;

    public NgIfAttribute(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "*ngIf=\"" + expression + "\"";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getValue() {
        return "";
    }
}
