package html;

public class Html {
    public Div div;

    public Html(Div div) {
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
        return "Html{" +
                "div=" + div +
                '}';
    }
}
