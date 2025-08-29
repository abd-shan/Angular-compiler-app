package symbolTable;

public class Symbol {
    private final String name;
    private final String type;
    private final int line;
    private final int column;

    public Symbol(String name, String type) {
        this(name, type, -1, -1);
    }

    public Symbol(String name, String type, int line, int column) {
        this.name = name;
        this.type = type;
        this.line = line;
        this.column = column;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getLine() { return line; }
    public int getColumn() { return column; }

    @Override
    public String toString() {
        return name + ":" + type + " (line " + line + ", col " + column + ")";
    }
}