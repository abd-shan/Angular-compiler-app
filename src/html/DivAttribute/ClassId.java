package html.DivAttribute;

public class ClassId extends DivAttribute{
    public String attribute;
    public ClassId(String attribute) {
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
        return "ClassId{" +
                "attribute='" + attribute + '\'' +
                '}';
    }
}
