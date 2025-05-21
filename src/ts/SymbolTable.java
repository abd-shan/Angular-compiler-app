package ts;

import ts.expressions.Expression;
import ts.types.Type;

import java.util.ArrayList;




public class SymbolTable {

    private class Symbol{
        String name;
        Type type;
        String scope;
    }

ArrayList<Symbol> symbols;

}
