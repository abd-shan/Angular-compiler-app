package html.Paragraph;

public class H_Element extends ParagraphElement{
    public String id1;
    public String binding;
    public String id2;

    public H_Element(String id1, String binding, String id2) {
        this.id1 = id1;
        this.binding = binding;
        this.id2 = id2;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "HElement{" +
                 id1 + '\'' +
                ", binding='" + binding + '\'' +
                '}';
    }
}
