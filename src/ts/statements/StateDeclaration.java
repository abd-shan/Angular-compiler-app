package  ts.statements;

import java.util.Map;

public class StateDeclaration implements TsStatement {
    private Map<String, Object> stateProperties;

    public StateDeclaration(Map<String, Object> stateProperties) {
        this.stateProperties = stateProperties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("state: {\n");

        for (Map.Entry<String, Object> entry : stateProperties.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue().toString()).append(",\n");
        }

        sb.append("}");
        return sb.toString();
    }

    // Getters and setters
    public Map<String, Object> getStateProperties() { return stateProperties; }
}