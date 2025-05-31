package html;

public class HtmlSymbol {
    String name;
    String type;   // Attributes
    String scope;

    public HtmlSymbol(String name, String type, String scope) {
        this.name = name;
        this.type = type;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getScope() {
        return scope;
    }
}
