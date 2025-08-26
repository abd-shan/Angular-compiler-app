package html.attribute;

// Standard Attribute
public class StandardAttribute extends HtmlAttribute {
    private String name;
    private String value;

    public StandardAttribute(String name, String value) {
        this.name = name != null ? name : "";
        this.value = value != null ? value : "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        return name + "=\"" + value + "\"";
    }
}