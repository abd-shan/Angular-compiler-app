package ast.component;

import java.util.Objects;

public class SimpleProvider extends ProviderExpression {
    private final String providerName;

    public SimpleProvider(String providerName) {
        this.providerName = Objects.requireNonNull(providerName);
    }

    public String getProviderName() { return providerName; }

    @Override
    public String toString() {
        return providerName;
    }
}