package html.DivChild;

import html.DivNode;

public class NestedDiv extends DivChild{
    public DivNode div;
    public NestedDiv(DivNode div) {
        this.div = div;
    }


    public DivNode getDiv() {
        return div;
    }

    public void setDiv(DivNode div) {
        this.div = div;
    }

    @Override
    public String toString() {
        return  div.toString() ;
    }
}
