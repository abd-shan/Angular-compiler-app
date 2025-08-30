package symbolTable.Import;

import java.util.*;

public final class ImportScope {
    private final String scopeName;
    // خريطة للبحث السريع عن الرموز
    private final Map<String, ImportSymbol> symbols = new LinkedHashMap<>();
    // قائمة لتخزين جميع الرموز المضافة (حتى المكررة)
    private final List<ImportSymbol> allSymbols = new ArrayList<>();

    public ImportScope(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeName() { return scopeName; }

    public void define(ImportSymbol sym) {
        if (sym == null) return;

        // إضافة الرمز إلى قائمة جميع الرموز (حتى المكررة)
        allSymbols.add(sym);

        // إضافة الرمز إلى الخريطة للبحث السريع (تستبدل القديم إذا وجد)
        symbols.put(sym.getName(), sym);

        if (sym.getAlias() != null && !sym.getAlias().isEmpty()) {
            symbols.put(sym.getAlias(), sym);
        }
    }

    public ImportSymbol resolve(String name) {
        return symbols.get(name);
    }

    public Collection<ImportSymbol> getAllSymbols() {
        // إرجاع جميع الرموز المضافة (حتى المكررة)
        return Collections.unmodifiableCollection(allSymbols);
    }

    // دالة جديدة للحصول على الرموز الفريدة فقط (للاستخدام في أماكن أخرى إذا لزم الأمر)
    public Collection<ImportSymbol> getUniqueSymbols() {
        return Collections.unmodifiableCollection(symbols.values());
    }
}