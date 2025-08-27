package symbolTable;

public class SymbolTable {
    private Scope currentScope;

    public void enterScope(String name) {
        Scope child = new Scope(name, currentScope);
        if (currentScope != null) {
            currentScope.addChild(child);
        }
        currentScope = child;
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

    private void printScope(StringBuilder sb, Scope scope, int depth) {
        if (scope == null) return;
        sb.append("  ".repeat(Math.max(0, depth)))
          .append(scope.toString())
          .append('\n');
        for (Scope child : scope.getChildren()) {
            printScope(sb, child, depth + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Find root
        Scope root = currentScope;
        while (root != null && root.getParent() != null) {
            root = root.getParent();
        }
        printScope(sb, root, 0);
        return sb.toString();
    }
}
