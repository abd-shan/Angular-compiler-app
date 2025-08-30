package semantic;

import symbolTable.Import.ImportScope;
import symbolTable.Import.ImportSymbol;
import symbolTable.Import.ImportSymbolTable;

import java.util.*;

public class ImportSemanticAnalyzer {
    private final ImportSymbolTable importSymbolTable;
    private final List<String> errors = new ArrayList<>();

    public ImportSemanticAnalyzer(ImportSymbolTable importSymbolTable) {
        this.importSymbolTable = importSymbolTable;
    }

    public void analyze() {
        checkDuplicateImportsInSameScope();
    }

    private void checkDuplicateImportsInSameScope() {
        for (ImportScope scope : importSymbolTable.getAllScopes()) {

            Set<String> seenSymbols = new HashSet<>();
            Map<String, List<ImportSymbol>> realDuplicates = new HashMap<>();

            for (ImportSymbol symbol : scope.getAllSymbols()) {
                String symbolKey = symbol.getName() + "|" + symbol.getModulePath() +
                        "|" + symbol.getLine() + "|" + symbol.getColumn();

                if (seenSymbols.contains(symbolKey)) {

                    continue;
                }


                if (seenSymbols.stream().anyMatch(key -> key.startsWith(symbol.getName() + "|") && !key.equals(symbolKey))) {

                    realDuplicates.computeIfAbsent(symbol.getName(), k -> new ArrayList<>()).add(symbol);
                }

                seenSymbols.add(symbolKey);
            }


            for (Map.Entry<String, List<ImportSymbol>> entry : realDuplicates.entrySet()) {
                String symbolName = entry.getKey();
                List<ImportSymbol> duplicates = entry.getValue();

                StringBuilder errorMsg = new StringBuilder();
                errorMsg.append("Duplicate import '").append(symbolName)
                        .append("' in scope '").append(scope.getScopeName()).append("':");

                for (ImportSymbol duplicate : duplicates) {
                    errorMsg.append("\n  - From '").append(duplicate.getModulePath())
                            .append("' at [").append(duplicate.getLine())
                            .append(":").append(duplicate.getColumn()).append("]");
                }

                errors.add(errorMsg.toString());
            }
        }
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void printErrors() {
        if (errors.isEmpty()) {
            System.out.println("\u001B[32mNo import errors found.\u001B[0m");
            return;
        }

        System.out.println("\n\u001B[31m╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     IMPORT ERRORS                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\u001B[0m");

        for (String error : errors) {
            System.out.println("\u001B[31m- " + error + "\u001B[0m");
        }

        System.out.println("\u001B[31m══════════════════════════════════════════════════════════════\u001B[0m");
        System.out.printf("\u001B[31mTotal: %d error(s)\u001B[0m\n\n", errors.size());
    }
}