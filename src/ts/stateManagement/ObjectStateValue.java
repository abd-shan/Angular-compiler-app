package ts.stateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ObjectStateValue - يمثل قيمة كائن تحتوي على خصائص أخرى
 */
public class ObjectStateValue implements StateValue {
    private final List<StateProperty> properties;

    public ObjectStateValue(List<StateProperty> properties) {
        this.properties = properties != null ? new ArrayList<>(properties) : new ArrayList<>();
    }

    @Override
    public ValueType getType() {
        return ValueType.OBJECT;
    }

    public List<StateProperty> getProperties() {
        return Collections.unmodifiableList(properties);
    }

    public void addProperty(StateProperty property) {
        if (property != null) {
            properties.add(property);
        }
    }

    public StateProperty getProperty(String name) {
        return properties.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < properties.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(properties.get(i).toString());
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toCodeString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < properties.size(); i++) {
            if (i > 0) sb.append(", ");
            StateProperty prop = properties.get(i);
            sb.append(prop.getName()).append(": ").append(prop.getValue().toCodeString());
        }
        sb.append("}");
        return sb.toString();
    }
}