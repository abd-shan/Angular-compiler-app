package html.DivAttribute;

public class NgDirective extends DivAttribute{
    public String directive;
    public NgDirective(String directive) {
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
        return  directive + '\'' ;
    }
}
