package html.attribute;

// Boolean Attribute
public class BooleanAttribute extends HtmlAttribute {
    private String name;

    public BooleanAttribute(String name) {
        this.name = name != null ? name : "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return "";
    }


    @Override
    public String toString() {
        return name;
    }
}