package ts.expressions;

import ts.Kind;
import ts.types.Type;

public class Variable extends Expression {
    private String name;
    private Kind kind;
    private Type type;

    public Variable(String name, Kind kind, Type type) {
        this.name = name;
        this.kind = kind;
        this.type = type;
    }

    public Variable(String name, Kind kind) {
        this.kind = kind;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name + ":" + kind + " ";
    }
}
