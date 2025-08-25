package ts.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TsType {
    private final List<GenericOrBasicType> types;

    public TsType(List<GenericOrBasicType> types) {
        this.types = types != null ? new ArrayList<>(types) : new ArrayList<>();
    }

    public List<GenericOrBasicType> getTypes() {
        return Collections.unmodifiableList(types);
    }

    public boolean isUnionType() {
        return types.size() > 1;
    }

    @Override
    public String toString() {
        if (types.isEmpty()) return "any";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.size(); i++) {
            if (i > 0) sb.append(" | ");
            sb.append(types.get(i).toString());
        }
        return sb.toString();
    }
}