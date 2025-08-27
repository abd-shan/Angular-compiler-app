package  ast.ts.expressions;

public class Identifier implements TsExpression {
    private String name;

    public Identifier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Getters and setters
    public String getName() { return name; }
}