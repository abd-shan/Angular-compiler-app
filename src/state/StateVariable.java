package state;


import java.util.Objects;

public class StateVariable {
    private final String name;
    private final String type; // type String (name ID)
    private final Object value; // objectValue can be : Map or List or String

    public StateVariable(String name, String type, Object value) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
        this.value = value;
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

    @Override
    public String toString() {
        return "StateVariable{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}

