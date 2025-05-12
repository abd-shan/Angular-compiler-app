package ts;

public class Number extends Type{
    int number;

    public Number() {
        this.number = 0;
    }

    public Number(int number ) {
        this.number = number;
    }

    public String toString() {
        return "number: "+Integer.toString(number)+"\n";
    }
}
