package html.attribute;

public class HtmlAttribute {
    private HtmlAttributeType type;
    private String name;      //  ngIf , src , click
    private String value;     //  "" , Boolean

    public HtmlAttribute(HtmlAttributeType type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    // Getters & Setters

    public HtmlAttributeType getType() {
        return type;
    }

    public void setType(HtmlAttributeType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HtmlAttribute{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

