package html;

public class ParagraphNode extends Html {
    private String paragraph;

    public ParagraphNode(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public String toString() {
        return "p{   " + paragraph + "   }";
    }
}

