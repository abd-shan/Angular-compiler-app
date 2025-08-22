package symbolTable.html;

public class HtmlSymbol {
    String name;
    String attribute;   // Attributes
    String scope;

    public HtmlSymbol(String name, String attribute, String scope) {
        this.name = name;
        this.attribute = attribute;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getScope() {
        return scope;
    }
}
