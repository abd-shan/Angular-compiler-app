package symbolTable;

import java.util.*;

public class Scope {
    private final String name;
    private final Scope parent;
    private final Map<String, Symbol> symbols = new HashMap<>();
    private final List<Scope> children = new ArrayList<>();

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
    }

    public void define(Symbol sym) {
        symbols.put(sym.getName(), sym);
    }

    public Symbol resolve(String name) {
        Symbol sym = symbols.get(name);
        if (sym != null) return sym;
        if (parent != null) return parent.resolve(name);
        return null;
    }

    public Scope getParent() { return parent; }

    public String getName() { return name; }

    public Map<String, Symbol> getSymbols() { return Collections.unmodifiableMap(symbols); }

    public void addChild(Scope child) { if (child != null) children.add(child); }

    public List<Scope> getChildren() { return Collections.unmodifiableList(children); }

    @Override
    public String toString() {
        return "Scope(" + name + ") symbols=" + symbols;
    }
}

