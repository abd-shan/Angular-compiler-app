package state;


import java.util.Objects;

public class StateAction {
    private final String name;
    private final String type; // operation type
    private final Object payload; // tsExpr if exist
    private final boolean isExported;
    private final boolean isConst;


    public StateAction(String name, String type, Object payload, boolean isExported, boolean isConst) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
        this.payload = payload;
        this.isExported = isExported;
        this.isConst = isConst;
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


    public boolean isExported() {
        return isExported;
    }

    public boolean isConst() {
        return isConst;
    }

    @Override
    public String toString() {
        return "StateAction{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", payload=" + payload +
                ", isExported=" + isExported() +
                '}';
    }
}
