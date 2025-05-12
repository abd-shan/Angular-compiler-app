package ts;

public class Bool extends Type {
    private boolean value;

    public Bool() {
        this.value = false;
    }

    public Bool(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String toString() {
        return value ? "true" : "false";
    }
}
