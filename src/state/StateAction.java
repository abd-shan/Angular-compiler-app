package state;


import java.util.Objects;

public class StateAction {
    private final String name;
    private final String type; // operation type
    private final Object payload; // tsExpr if exist

    public StateAction(String name, String type, Object payload) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
        this.payload = payload;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Object getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "StateAction{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", payload=" + payload +
                '}';
    }
}
