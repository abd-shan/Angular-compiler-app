package html;

public class ClassidNode extends Html {
    private String attribute;

    public ClassidNode(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return attribute;
//        return "ClassidNode{" +
//                "attribute='" + attribute + '\'' +
//                '}';
    }
}