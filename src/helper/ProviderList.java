package helper;

import component.ProviderExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProviderList {
    private final List<ProviderExpression> providers = new ArrayList<>();

    public void addProvider(ProviderExpression provider) {
        if (provider != null) {
            providers.add(provider);
        }
    }

    public List<ProviderExpression> getProviders() {
        return Collections.unmodifiableList(providers);
    }
}