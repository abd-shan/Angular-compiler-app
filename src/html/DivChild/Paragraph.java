package html.DivChild;

import html.ParagraphElement.ParagraphElement;

public class Paragraph {
    public ParagraphElement paragraph;
    public Paragraph(ParagraphElement paragraph) {
        this.paragraph = paragraph;
    }


    public ParagraphElement getParagraph() {
        return paragraph;
    }

    public void setParagraph(ParagraphElement paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "paragraph=" + paragraph +
                '}';
    }
}
