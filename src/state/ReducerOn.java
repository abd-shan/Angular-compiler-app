package state;


import ts.expressions.ArrowFunction;

import java.util.Objects;

public class ReducerOn {
    private final String actionName;
    private final ArrowFunction handler;

    public ReducerOn(String actionName, ArrowFunction handler) {
        this.actionName = Objects.requireNonNull(actionName);
        this.handler = Objects.requireNonNull(handler);
    }

    public String getActionName() {
        return actionName;
    }

    public ArrowFunction getHandler() {
        return handler;
    }

    @Override
    public String toString() {
        return "on(" + actionName + ", " + handler + ")";
    }
}
