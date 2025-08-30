package symbolTable.Import;

public final class ImportSymbol {
    private final String name;
    private final String alias;
    private final String modulePath;
    private final int line;
    private final int column;

    public ImportSymbol(String name, String alias, String modulePath, int line, int column) {
        this.name = name;
        this.alias = alias;
        this.modulePath = modulePath;
        this.line = line;
        this.column = column;
    }

    public String getName() { return name; }
    public String getAlias() { return alias; }
    public String getModulePath() { return modulePath; }
    public int getLine() { return line; }
    public int getColumn() { return column; }

    @Override
    public String toString() {
        if (alias != null) {
            return String.format("%s (alias %s) from %s [%d:%d]", name, alias, modulePath, line, column);
        } else {
            return String.format("%s from %s [%d:%d]", name, modulePath, line, column);
        }
    }
}
