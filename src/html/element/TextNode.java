package html.element;

import html.HtmlNode;

public class TextNode implements HtmlNode {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

