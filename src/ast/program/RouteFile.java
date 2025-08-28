package ast.program;

import ast.router.RouteElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class RouteFile implements AngularFile {
    private final List<String> importStatements = new ArrayList<>();
    private final List<RouteElement> routes = new ArrayList<>();

    public void addImport(String imp) {
        if (imp != null && !imp.trim().isEmpty()) importStatements.add(imp);
    }

    public List<String> getImportStatements() {
        return Collections.unmodifiableList(importStatements);
    }

    public void addRoute(RouteElement r) {
        if (r != null) routes.add(r);
    }

    public List<RouteElement> getRoutes() {
        return Collections.unmodifiableList(routes);
    }

    @Override
    public String toString() {
        return "RouteFile{\n imports=" + importStatements + ",\n routes=" + routes + "\n}";
    }
}
