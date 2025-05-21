package ts.expressions;

import ts.Kind;

public class Variable extends Expression {
    private String name;
    private Kind kind;

    public Variable(String name, Kind kind) {
        this.name = name;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", kind=" + kind +
                '}';
    }
}
