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
        System.out.println("\n\u001B[1;36m==== Import Symbol Table ====\u001B[0m");

        if (allScopes.isEmpty()) {
            System.out.println("\u001B[33m(no imports)\u001B[0m");
            return;
        }


        int maxScopeNameLength = allScopes.stream()
                .mapToInt(scope -> scope.getScopeName().length())
                .max()
                .orElse(20);

        maxScopeNameLength = Math.min(Math.max(maxScopeNameLength, 20), 40);


        System.out.printf("\u001B[1;35m%-" + maxScopeNameLength + "s | %-50s | %s\u001B[0m%n",
                "Scope", "Symbol", "Location");


        String separatorLine = String.format("%-" + maxScopeNameLength + "s-+-%-50s-+-%s",
                "-".repeat(maxScopeNameLength),
                "-".repeat(50),
                "-".repeat(15));
        System.out.println(separatorLine);


        for (ImportScope scope : allScopes) {
            String scopeName = scope.getScopeName();
            Collection<ImportSymbol> symbols = scope.getAllSymbols();

            if (symbols.isEmpty()) {
                System.out.printf("\u001B[1;32m%-" + maxScopeNameLength + "s | %-50s | %s\u001B[0m%n",
                        scopeName, "(no imports)", "");
            } else {
                boolean isFirstSymbol = true;
                for (ImportSymbol sym : symbols) {
                    if (isFirstSymbol) {
                        System.out.printf("\u001B[1;32m%-" + maxScopeNameLength + "s | \u001B[0m%-50s | [%d:%d]%n",
                                scopeName, sym.toString(), sym.getLine(), sym.getColumn());
                        isFirstSymbol = false;
                    } else {
                        System.out.printf("%-" + maxScopeNameLength + "s | %-50s | [%d:%d]%n",
                                "", sym.toString(), sym.getLine(), sym.getColumn());
                    }
                }
                System.out.println(separatorLine);
            }
        }
        System.out.println("\u001B[1;36m============================================\u001B[0m\n");
    }
}
