package symbolTable.Import;

import java.util.*;

public final class ImportSymbolTable {
    private final Deque<ImportScope> scopeStack = new ArrayDeque<>();


    private final List<ImportScope> allScopes = new ArrayList<>();

    public void enterScope(String name) {
        ImportScope sc = new ImportScope(name);
        scopeStack.push(sc);
        allScopes.add(sc);
    }

    public void exitScope() {
        if (!scopeStack.isEmpty()) {
            scopeStack.pop();
        }
    }

    public void define(ImportSymbol sym) {
        if (sym == null) return;
        if (!scopeStack.isEmpty()) {
            scopeStack.peek().define(sym);
        } else {


            Optional<ImportScope> global = allScopes.stream().filter(s -> s.getScopeName().equals("<global>")).findFirst();
            ImportScope sc;
            if (global.isPresent()) sc = global.get();
            else {
                sc = new ImportScope("<global>");
                allScopes.add(sc);
            }
            sc.define(sym);
        }
    }

    public List<ImportScope> getAllScopes() {
        return Collections.unmodifiableList(allScopes);
    }

    public ImportSymbol resolve(String name) {

        for (ImportScope sc : scopeStack) {
            ImportSymbol sym = sc.resolve(name);
            if (sym != null) return sym;
        }

        for (int i = allScopes.size() - 1; i >= 0; i--) {
            ImportScope sc = allScopes.get(i);
            ImportSymbol sym = sc.resolve(name);
            if (sym != null) return sym;
        }
        return null;
    }

    public void printTable() {
        System.out.println("\n\u001B[1;36m╔══════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[1;36m║                     IMPORT SYMBOL TABLE                      ║\u001B[0m");
        System.out.println("\u001B[1;36m╚══════════════════════════════════════════════════════════════╝\u001B[0m");

        if (allScopes.isEmpty()) {
            System.out.println("\u001B[33m(no imports)\u001B[0m");
            return;
        }


        int maxScopeNameLength = allScopes.stream()
                .mapToInt(scope -> scope.getScopeName().length())
                .max()
                .orElse(20);

        int maxSymbolLength = allScopes.stream()
                .flatMap(scope -> scope.getAllSymbols().stream())
                .mapToInt(sym -> sym.toString().length())
                .max()
                .orElse(50);


        maxScopeNameLength = Math.min(Math.max(maxScopeNameLength, 15), 30);
        maxSymbolLength = Math.min(Math.max(maxSymbolLength, 30), 70);


        System.out.printf("\u001B[1;35m%-" + maxScopeNameLength + "s │ %-" + maxSymbolLength + "s │ %s\u001B[0m%n",
                "SCOPE", "SYMBOL", "LOCATION");


        String separatorLine = String.format("%s─┼─%s─┼─%s",
                "─".repeat(maxScopeNameLength),
                "─".repeat(maxSymbolLength),
                "─".repeat(10));
        System.out.println(separatorLine);


        for (ImportScope scope : allScopes) {
            String scopeName = scope.getScopeName();
            Collection<ImportSymbol> symbols = scope.getAllSymbols();

            if (symbols.isEmpty()) {
                System.out.printf("\u001B[1;32m%-" + maxScopeNameLength + "s │ %-" + maxSymbolLength + "s │ %s\u001B[0m%n",
                        scopeName, "(no imports)", "");
            } else {
                boolean isFirstSymbol = true;
                for (ImportSymbol sym : symbols) {
                    String symbolStr = sym.toString();


                    if (symbolStr.length() > maxSymbolLength) {
                        symbolStr = symbolStr.substring(0, maxSymbolLength - 3) + "...";
                    }

                    if (isFirstSymbol) {
                        System.out.printf("\u001B[1;32m%-" + maxScopeNameLength + "s │ \u001B[0m%-" + maxSymbolLength + "s │ [%d:%d]%n",
                                scopeName, symbolStr, sym.getLine(), sym.getColumn());
                        isFirstSymbol = false;
                    } else {
                        System.out.printf("%-" + maxScopeNameLength + "s │ %-" + maxSymbolLength + "s │ [%d:%d]%n",
                                "", symbolStr, sym.getLine(), sym.getColumn());
                    }
                }
                System.out.println(separatorLine);
            }
        }


        int totalImports = allScopes.stream()
                .mapToInt(scope -> scope.getAllSymbols().size())
                .sum();

        System.out.printf("\u001B[90mTotal: %d scope(s), %d import(s)\u001B[0m%n%n",
                allScopes.size(), totalImports);
    }
}
