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
    private final boolean isExported;
    private final boolean isConst;


    public StateReducer(String name, String stateName, boolean isExported, boolean isConst) {
        this.name = Objects.requireNonNull(name);
        this.stateName = Objects.requireNonNull(stateName);
        this.isExported = isExported;
        this.isConst = isConst;
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

    public boolean isExported() {
        return isExported;
    }

    public boolean isConst() {
        return isConst;
    }

    @Override
    public String toString() {
        return "StateReducer{" + '\n'+
                "name='" + name + '\'' +'\n'+
                ", stateName='" + stateName + '\'' + '\n'+
                ", onList=" + onList + '\n'+
                ", isExported=" + isExported() + '\n'+
                '}';
    }
}

