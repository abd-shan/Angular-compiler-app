package html;

public class H2Node extends Html {
    private String h2;

    public H2Node(String h2) {
        this.h2 = h2;
    }

    @Override
    public String toString() {
        return "h2{   " + h2 + "   }";
    }
}


