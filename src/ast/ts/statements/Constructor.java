package  ast.ts.statements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constructor implements TsStatement {
    private final List<ConstructorParam> parameters;
    private final TsBlock body;
    private final String primitiveDataType;

    public Constructor(List<ConstructorParam> parameters, TsBlock body, String primitiveDataType) {
        this.parameters = parameters != null ? new ArrayList<>(parameters) : new ArrayList<>();
        this.body = body;
        this.primitiveDataType = primitiveDataType;
    }

    public List<ConstructorParam> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    public TsBlock getBody() {
        return body;
    }

    public String getPrimitiveDataType() {
        return primitiveDataType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (primitiveDataType != null) {
            sb.append(primitiveDataType).append(" ");
        }

        sb.append("constructor(");

        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(parameters.get(i).toString());
        }

        sb.append(") {\n");

        if (body != null) {
            sb.append(body.toString()).append("\n");
        }

        sb.append("}");

        return sb.toString();
    }
}
