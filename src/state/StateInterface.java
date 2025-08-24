package state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StateInterface {
    private final String name;
    private final List<StateInterfaceProperty> properties = new ArrayList<>();

    public StateInterface(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public void addProperty(StateInterfaceProperty prop) {
        Objects.requireNonNull(prop);
        properties.add(prop);
    }

    public List<StateInterfaceProperty> getProperties() {
        return Collections.unmodifiableList(properties);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StateInterface{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}