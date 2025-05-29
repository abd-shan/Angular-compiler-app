package html.DivAttribute;

public class Ng extends DivAttribute{
    public String directive;
    public Ng(String directive) {
        this.directive = directive;
    }

    public String getNg() {
        return directive;
    }

    public void setNg(String directive) {
        this.directive = directive;
    }

    @Override
    public String toString() {
        return "Ng directive{" +
                "Ng directive='" + directive + '\'' +
                '}';
    }
}
