package ts.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GenericType extends GenericOrBasicType {
    private final String typeName;
    private final List<GenericTypeParam> typeParameters;

    public GenericType(String typeName, List<GenericTypeParam> typeParameters) {
        this.typeName = Objects.requireNonNull(typeName);
        this.typeParameters = typeParameters != null ? new ArrayList<>(typeParameters) : new ArrayList<>();
    }

    public String getTypeName() {
        return typeName;
    }

    public List<GenericTypeParam> getTypeParameters() {
        return Collections.unmodifiableList(typeParameters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(typeName);

        if (!typeParameters.isEmpty()) {
            sb.append("<");
            for (int i = 0; i < typeParameters.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(typeParameters.get(i).toString());
            }
            sb.append(">");
        }

        return sb.toString();
    }
}