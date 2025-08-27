package ast.state;


import java.util.Objects;

public class InjectableOptions {
    private final String providedIn;

    public InjectableOptions(String providedIn) {
        this.providedIn = Objects.requireNonNull(providedIn);
    }

    public String getProvidedIn() {
        return providedIn;
    }

    @Override
    public String toString() {
        return "InjectableOptions{" +
                "providedIn='" + providedIn + '\'' +
                '}';
    }
}
