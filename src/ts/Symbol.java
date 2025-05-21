package ts;

import ts.types.Type;

public class Symbol {
    String name;
    Kind kind;
    Type type;
    String scope;

    public Symbol(String name, Kind kind, Type type, String scope) {
        this.name = name;
        this.kind = kind;
        this.type = type;
        this.scope = scope;
    }
}
