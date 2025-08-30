package symbolTable.Import;

import java.util.*;

public final class ImportScope {
    private final String scopeName;
    // key -> name or alias  -> ImportSymbol
    private final Map<String, ImportSymbol> symbols = new LinkedHashMap<>();

    public ImportScope(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeName() { return scopeName; }

    public void define(ImportSymbol sym) {
        if (sym == null) return;

        symbols.put(sym.getName(), sym);

        if (sym.getAlias() != null && !sym.getAlias().isEmpty()) {
            symbols.put(sym.getAlias(), sym);
        }
    }

    public ImportSymbol resolve(String name) {
        return symbols.get(name);
    }

    public Collection<ImportSymbol> getAllSymbols() {

        Set<ImportSymbol> uniq = new LinkedHashSet<>(symbols.values());
        return Collections.unmodifiableCollection(uniq);
    }
}
