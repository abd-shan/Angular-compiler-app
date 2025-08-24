package ts.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericType extends TsType {
    private final String baseName;
    private final List<TsType> typeParams = new ArrayList<>();

    public GenericType(String baseName) {
        this.baseName = baseName;
    }

    public void addTypeParam(TsType param) {
        typeParams.add(param);
    }

    public List<TsType> getTypeParams() {
        return Collections.unmodifiableList(typeParams);
    }

    public String getBaseName() {
        return baseName;
    }

    @Override
    public String toString() {
        return baseName + "<" + String.join(", ", typeParams.stream().map(Object::toString).toList()) + ">";
    }
}
