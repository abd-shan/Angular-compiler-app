package  ts.expressions;

import java.util.Map;

public class ObjectLiteral implements TsExpression {
    private Map<String, TsExpression> properties;

    public ObjectLiteral(Map<String, TsExpression> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        if (properties != null && !properties.isEmpty()) {
            boolean first = true;
            for (Map.Entry<String, TsExpression> entry : properties.entrySet()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.getKey()).append(": ").append(entry.getValue().toString());
                first = false;
            }
        }

        sb.append("}");
        return sb.toString();
    }

    // Getters and setters
    public Map<String, TsExpression> getProperties() { return properties; }
}