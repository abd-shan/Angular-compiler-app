package state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StateInterface {
    private final String name;
    private final List<StateInterfaceProperty> properties = new ArrayList<>();
    private final boolean isExported;

    public StateInterface(String name, boolean isExported) {
        this.name = Objects.requireNonNull(name);
        this.isExported = isExported;
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

    public boolean isExported() { return isExported; }

    @Override
    public String toString() {
        return "StateInterface{" +'\n'+
                "name='" + name + '\'' +'\n'+
                ", properties=" + properties +'\n'+
                ", isExported=" + isExported() +'\n'+
                '}';
    }
}