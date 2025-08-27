package ast.state;

import java.util.ArrayList;
import java.util.List;

public class ReducerOnList {
    private final List<ReducerOn> onList = new ArrayList<>();

    public void addOn(ReducerOn on) {
        onList.add(on);
    }

    public List<ReducerOn> getOnList() {
        return onList;
    }
}