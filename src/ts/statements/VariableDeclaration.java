package ts.statements;


import ts.expressions.TsExpression;
import ts.types.Type;
import ts.modifiers.Modifier;
import java.util.List;

public class VariableDeclaration implements TsStatement {
    private String variableName;
    private Type type;
    private TsExpression initialValue;
    private List<Modifier> modifiers;
    private boolean isConst;

    public VariableDeclaration(String variableName, Type type, TsExpression initialValue,
                               List<Modifier> modifiers, boolean isConst) {
        this.variableName = variableName;
        this.type = type;
        this.initialValue = initialValue;
        this.modifiers = modifiers;
        this.isConst = isConst;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // modifiers
        if (modifiers != null) {
            for (Modifier modifier : modifiers) {
                sb.append(modifier.toString()).append(" ");
            }
        }

        // const/let
        sb.append(isConst ? "const " : "let ");

        // variable name
        sb.append(variableName);

        // type annotation
        if (type != null) {
            sb.append(": ").append(type.toString());
        }

        // initial value
        if (initialValue != null) {
            sb.append(" = ").append(initialValue.toString());
        }

        sb.append(";");
        return sb.toString();
    }

    // Getters and setters
    public String getVariableName() { return variableName; }
    public Type getType() { return type; }
    public TsExpression getInitialValue() { return initialValue; }
    public List<Modifier> getModifiers() { return modifiers; }
    public boolean isConst() { return isConst; }
}