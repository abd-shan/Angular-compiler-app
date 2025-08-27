package ast.ts.stateManagement;

import java.util.Objects;

/**
 * StateProperty - يمثل خاصية فردية داخل الحالة
 * يحتوي على اسم وقيمة
 */
public class StateProperty {
    private final String name;
    private final StateValue value;

    public StateProperty(String name, StateValue value) {
        this.name = Objects.requireNonNull(name, "Property name cannot be null");
        this.value = Objects.requireNonNull(value, "Property value cannot be null");
    }

    public String getName() {
        return name;
    }

    public StateValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }
}