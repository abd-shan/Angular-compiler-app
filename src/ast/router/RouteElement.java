package ast.router;


import java.util.Objects;


public class RouteElement {
    private final String path;        // e.g. "products" or "product/:id"
    private final String component;   // e.g. "ProductListComponent"

    public RouteElement(String path, String component) {
        this.path = Objects.requireNonNull(path, "path is null");
        this.component = Objects.requireNonNull(component, "component is null");
    }

    public String getPath() {
        return path;
    }

    public String getComponent() {
        return component;
    }

    @Override
    public String toString() {
        return "RouteElement{path='" + path + "', component='" + component + "'}";
    }
}
