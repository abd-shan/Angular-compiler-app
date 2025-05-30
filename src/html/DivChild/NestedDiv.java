package html.DivChild;

import html.Div;

public class NestedDiv extends DivChild{
    public Div div;
    public NestedDiv(Div div) {
        this.div = div;
    }


    public Div getDiv() {
        return div;
    }

    public void setDiv(Div div) {
        this.div = div;
    }

    @Override
    public String toString() {
        return "NestedDiv{" +
                "div=" + div +
                '}';
    }
}
