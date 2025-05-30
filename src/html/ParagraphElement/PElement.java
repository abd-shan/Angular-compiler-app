package html.ParagraphElement;

public class PElement extends ParagraphElement{
    public String binding;

    public PElement(String binding) {
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
