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

        sb.append(String.format(" %-26s │ %-80s │ %-80s \n", "Name", "Attribute", "Scope"));

        sb.append("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        for (HtmlSymbol symbol : symbols) {
            sb.append(String.format("  %-26s │ %-80s │ %-80s \n",
                    symbol.getName(),
                    symbol.getAttribute(),
                    symbol.getScope()));
        }


        return sb.toString();
    }



}
