package  ast.ts.expressions;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents an object literal
 */
public class ObjectLiteral implements TsAtom {
    private final List<KeyValuePair> properties;

    public ObjectLiteral(List<KeyValuePair> properties) {
        this.properties = properties != null ? new ArrayList<>(properties) : new ArrayList<>();
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
}
