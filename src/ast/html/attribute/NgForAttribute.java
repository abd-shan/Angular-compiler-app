package ast.html.attribute;

// ngFor Directive

public class NgForAttribute extends HtmlAttribute {
    private String expression;

    public NgForAttribute(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "*ngFor=\"" + expression + "\"";
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
