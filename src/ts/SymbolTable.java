package ts;

import ts.types.Type;

import java.util.ArrayList;


public class SymbolTable {


    ArrayList<Symbol> symbols;

    public SymbolTable() {
        symbols = new ArrayList<>();
    }

    public void addSymbol(String name, Kind kind, String scope) {
        Symbol symbol = new Symbol(name, kind, null, scope);
        symbols.add(symbol);
    }

    public void addSymbol(String name, Kind kind, Type type, String scope) {
        Symbol symbol = new Symbol(name, kind, type, scope);
        symbols.add(symbol);
    }

//    public Symbol findSymbol(String symbolName, String scope) {
//        for (int i = symbols.size() - 1; i >= 0; i--) {
//            Symbol symbol = symbols.get(i);
//            if (symbol.name.equals(symbolName) && symbol.scope.equals(scope)) {
//                return symbol;
//            }
//        }
//        return null;
//    }

    public Symbol findSymbol(String symbolName, String scope) {
        while (scope != null && !scope.isEmpty()) {
            for (int i = symbols.size() - 1; i >= 0; i--) {
                Symbol symbol = symbols.get(i);
                if (symbol.name.equals(symbolName) && symbol.scope.equals(scope)) {
                    return symbol;
                }
            }

            // Step up to parent scope by removing the last scope segment
            int lastDot = scope.lastIndexOf('.');
            if (lastDot == -1) {
                scope = ""; // fallback to root/global scope
            } else {
                scope = scope.substring(0, lastDot);
            }
        }
        for (int i = symbols.size() - 1; i >= 0; i--) {
            Symbol symbol = symbols.get(i);
            if (symbol.name.equals(symbolName) && symbol.scope.equals(scope)) {
                return symbol;
            }
        }

        return null;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("┌────────────────────────┬────────────┬────────────┬────────────────────────┐\n");
        sb.append(String.format("│ %-22s │ %-10s │ %-10s │ %-22s │\n", "Name", "Kind", "Type", "Scope"));
        sb.append("├────────────────────────┼────────────┼────────────┼────────────────────────┤\n");

        for (Symbol symbol : symbols) {
            String typeStr = (symbol.type != null) ? symbol.type.toString() : "null";
            sb.append(String.format("│ %-22s │ %-10s │ %-10s │ %-22s │\n",
                    symbol.name,
                    symbol.kind.toString(),
                    typeStr,
                    symbol.scope));
        }

        sb.append("└────────────────────────┴────────────┴────────────┴────────────────────────┘\n");
        return sb.toString();
    }


}
