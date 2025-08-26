package symbolTable;

public class SymbolTable {
    private Scope currentScope;

    public void enterScope(String name) {
        currentScope = new Scope(name, currentScope);
    }

    public void exitScope() {
        if (currentScope != null) {
            currentScope = currentScope.getParent();
        }
    }

    public void define(String name, String type) {
        currentScope.define(new Symbol(name, type));
    }

    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    public Scope getCurrentScope() {
        return currentScope;
    }
}
