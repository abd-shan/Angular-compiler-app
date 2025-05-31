package html.DivChild;

import html.Paragraph.ParagraphElement;

public class ParagraphWrapper extends DivChild{
    public html.Paragraph.ParagraphElement paragraph;
    public ParagraphWrapper(html.Paragraph.ParagraphElement paragraph) {
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
        return
                paragraph.toString()
                ;
    }
}
