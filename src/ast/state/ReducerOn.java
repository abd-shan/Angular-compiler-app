package ast.state;


import java.util.Objects;

public class ReducerOn {
    private final String actionName;
    private final String handler;

    public ReducerOn(String actionName, String handler) {
        this.actionName = Objects.requireNonNull(actionName);
        this.handler =  handler;
    }

    public String getActionName() {
        return actionName;
    }

    public String getHandler() {
        return handler;
    }

    @Override
    public String toString() {
        return "on(" + actionName + ", " + handler + ")";
    }
}
