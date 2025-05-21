package ts.expressions;

import ts.Kind;

public class Attribute extends Expression {
    private String name;
    private Kind kind;

    public Attribute(String name, Kind kind) {
        this.name = name;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", kind=" + kind +
                '}';
    }
}
