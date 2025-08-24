package state;


import java.util.Objects;

public class StateVariable {
    private final String name;
    private final String type; // type String (name ID)
    private final Object value; // objectValue can be : Map or List or String
    private final boolean isExported;
    private final boolean isConst;


    public StateVariable(String name, String type, Object value, boolean isExported, boolean isConst) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
        this.value = value;
        this.isExported = isExported;
        this.isConst = isConst;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public boolean isConst() {
        return isConst;
    }

    public boolean isExported() {
        return isExported;
    }

    @Override
    public String toString() {
        return "StateVariable{" + '\n' +
                "name='" + name + '\'' + '\n' +
                ", type='" + type + '\'' + '\n' +
                ", value=" + value + '\n' +
                ", isExported=" + isExported + '\n' +
                '}';
    }
}

