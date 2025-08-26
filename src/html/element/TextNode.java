package html.element;

import html.HtmlNode;
import html.Node;



public class TextNode extends Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
