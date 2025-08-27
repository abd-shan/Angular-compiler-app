package ast.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProvidersOption {
    private final List<ProviderExpression> providers;

    public ProvidersOption(List<ProviderExpression> providers) {
        this.providers = providers != null ? new ArrayList<>(providers) : new ArrayList<>();
    }

    public List<ProviderExpression> getProviders() {
        return Collections.unmodifiableList(providers);
    }

    @Override
    public String toString() {
        return "Providers: " + providers;
    }
}