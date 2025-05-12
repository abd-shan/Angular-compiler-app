package html;

public class NgNode extends Html {
    private String directive;

    public NgNode(String directive) {
        this.directive = directive;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }


    @Override
    public String toString() {
        return directive;
//        return "NgNode{" +
//                "directive='" + directive + '\'' +
//                '}';
    }
}
