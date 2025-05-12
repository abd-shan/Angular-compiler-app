package html;

public class BrNode extends Html {
    private String br;

    public BrNode(String br) {
        this.br = br;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    @Override
    public String toString() {
       return "br{   " + br + "   }";

    }
}





