package ts.types;

import java.util.ArrayList;

public class Array extends Type {

    ArrayList<Type> array;

    public Array() {
        array = new ArrayList<>();
    }

    public ArrayList<Type> getArray() {
        return array;
    }

    public void setArray(ArrayList<Type> array) {
        this.array = array;
    }

    public void add(Type t) {
        array.add(t);
    }

    public void remove(Type t) {
        array.remove(t);
    }


    @Override
    public String toString() {
        return array.toString();
    }
}
