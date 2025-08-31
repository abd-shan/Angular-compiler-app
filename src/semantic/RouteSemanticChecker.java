package semantic;

import symbolTable.Import.ImportSymbol;
import symbolTable.Import.ImportSymbolTable;
import symbolTable.RouterSymbolTable;

import java.util.*;

public class RouteSemanticChecker {

    private final RouterSymbolTable routerSymbolTable;
    private final ImportSymbolTable importSymbolTable;
    private final List<String> errors = new ArrayList<>();

    public RouteSemanticChecker(RouterSymbolTable routerSymbolTable, ImportSymbolTable importSymbolTable) {
        this.routerSymbolTable = routerSymbolTable;
        this.importSymbolTable = importSymbolTable;
    }

    public void analyze() {
        checkRouteComponentsInImports();
    }

    public void checkRouteComponentsInImports() {

        Map<String, Set<String>> routes = routerSymbolTable.getRoutes();


        Set<String> importedSymbols = new HashSet<>();
        importSymbolTable.getScopeByName("RouteFile").ifPresent(scope -> {
            for (ImportSymbol symbol : scope.getAllSymbols()) {
                importedSymbols.add(symbol.getName());
            }
        });


        for (Map.Entry<String, Set<String>> entry : routes.entrySet()) {
            String path = entry.getKey();
            for (String component : entry.getValue()) {
                if (!importedSymbols.contains(component)) {
                    errors.add("Semantic Error: Component '" + component + "' used in route '" + path +
                            "' is not imported in RouteFile.");
                }
            }
        }
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void printErrors() {
        if (errors.isEmpty()) {
            System.out.println("No semantic errors found in RouteFile.");
        } else {
            System.out.println("==== Semantic Errors in RouteFile ====");
            errors.forEach(System.out::println);
            System.out.println("=======================================");
        }
    }
}
