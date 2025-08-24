package  ts.expressions;

public class PropertyAccess implements TsExpression {
    private TsExpression object;
    private String property;
    private boolean isThisAccess;

    public PropertyAccess(TsExpression object, String property) {
        this.object = object;
        this.property = property;
        this.isThisAccess = false;
    }

    public PropertyAccess(String property, boolean isThisAccess) {
        this.property = property;
        this.isThisAccess = isThisAccess;
        this.object = null;
    }

    @Override
    public String toString() {
        if (isThisAccess) {
            return "this." + property;
        }
        return object.toString() + "." + property;
    }

    // Getters and setters
    public TsExpression getObject() { return object; }
    public String getProperty() { return property; }
    public boolean isThisAccess() { return isThisAccess; }
}