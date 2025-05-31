package html.Paragraph;

public class P_Element extends ParagraphElement{
    public String binding;

    public P_Element(String binding) {
        this.binding = binding;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "PElement{" +
                "binding='" + binding + '\'' +
                '}';
    }
}
