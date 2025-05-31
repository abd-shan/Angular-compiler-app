package html;

import java.util.ArrayList;

public class HtmlSymbolTable {
    ArrayList<HtmlSymbol> symbols;

    public HtmlSymbolTable() {
        symbols = new ArrayList<>();
    }

    public void addSymbol(String name, String attribute, String scope) {
        symbols.add(new HtmlSymbol(name, attribute, scope));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<<<<<<<<<<<<<< HTML SYMBOL TABLE >>>>>>>>>>>>>>>>\n\n");
        sb.append(String.format("%-28s│ %-80s│ %-80s\n", "Name", "Attribute", "Scope"));
        sb.append("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");

        for (HtmlSymbol symbol : symbols) {
            String[] attrs = symbol.attribute.split("\\s+");
            boolean first = true;
            for (String attr : attrs) {
                if (first) {
                    sb.append(String.format("%-28s│ %-80s│ %-80s\n", symbol.name, attr, symbol.scope));
                    first = false;
                } else {
                    sb.append(String.format("%-28s│ %-80s│ %-80s\n", "", attr, ""));
                }
            }
            if (attrs.length == 0) {
                sb.append(String.format("%-28s│ %-80s│ %-80s\n", symbol.name, "", symbol.scope));
            }
        }

        return sb.toString();
    }

}
