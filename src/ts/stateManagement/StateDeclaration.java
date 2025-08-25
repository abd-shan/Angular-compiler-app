package ts.stateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * StateDeclaration - يمثل تعريف حالة كاملة
 * يحتوي على مجموعة من خصائص الحالة
 */
public class StateDeclaration {
    private final List<StateProperty> properties;

    public StateDeclaration(List<StateProperty> properties) {
        this.properties = properties != null ? new ArrayList<>(properties) : new ArrayList<>();
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
        return "StateDeclaration{properties=" + properties + "}";
    }
}
