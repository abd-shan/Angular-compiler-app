package ast.component;

import java.util.Objects;

public class ProvideStoreExpression extends ProviderExpression {
    private final String functionName;
    private final String configKey;
    private final String configValue;

    public ProvideStoreExpression(String functionName, String configKey, String configValue) {
        this.functionName = Objects.requireNonNull(functionName);
        this.configKey = Objects.requireNonNull(configKey);
        this.configValue = Objects.requireNonNull(configValue);
    }

    public String getFunctionName() { return functionName; }
    public String getConfigKey() { return configKey; }
    public String getConfigValue() { return configValue; }

    @Override
    public String toString() {
        return functionName + "({ " + configKey + ": " + configValue + " })";
    }
}