package ts.stateManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayStateValue - يمثل قيمة مصفوفة تحتوي على قيم أخرى
 */
public class ArrayStateValue implements StateValue {
    private final List<StateValue> values;

    public ArrayStateValue(List<StateValue> values) {
        this.values = values != null ? new ArrayList<>(values) : new ArrayList<>();
    }

    @Override
    public ValueType getType() {
        return ValueType.ARRAY;
    }

    public List<StateValue> getValues() {
        return Collections.unmodifiableList(values);
    }

    public void addValue(StateValue value) {
        if (value != null) {
            values.add(value);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(values.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toCodeString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(values.get(i).toCodeString());
        }
        sb.append("]");
        return sb.toString();
    }
}