package state;


import ts.expressions.ArrowFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StateReducer {
    private final String name;
    private final String stateName;
    private final List<ReducerOn> onList = new ArrayList<>();

    public StateReducer(String name, String stateName) {
        this.name = Objects.requireNonNull(name);
        this.stateName = Objects.requireNonNull(stateName);
    }

    public void addOn(ReducerOn on) {
        Objects.requireNonNull(on);
        onList.add(on);
    }

    public List<ReducerOn> getOnList() {
        return Collections.unmodifiableList(onList);
    }

    public String getName() {
        return name;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return "StateReducer{" + '\n'+
                "name='" + name + '\'' +'\n'+
                ", stateName='" + stateName + '\'' + '\n'+
                ", onList=" + onList + '\n'+
                '}';
    }
}

