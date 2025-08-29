package ast.html.element;

import ast.html.Node;
import ast.html.attribute.HtmlAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// ElementNode.java
public class ElementNode extends Node {
    private String tagName;
    private List<HtmlAttribute> attributes;
    private List<Node> children;
    private boolean selfClosing;

    public ElementNode(String tagName) {
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
        this.selfClosing = false;
    }

    public void addAttribute(HtmlAttribute attr) {
        attributes.add(attr);
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public void setSelfClosing(boolean selfClosing) {
        this.selfClosing = selfClosing;
    }

    public String getTagName() {
        return tagName;
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean isSelfClosing() {
        return selfClosing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append("\n")
          .append("<").append(tagName);

        if (!attributes.isEmpty()) {
            sb.append(" ");
            sb.append(attributes.stream()
                    .map(HtmlAttribute::toString)
                    .collect(Collectors.joining(" ")));
        }

        if (selfClosing) {
            sb.append("/>");
        } else {
            sb.append(">");
            for (Node child : children) {
                sb.append(child.toString());
            }
            sb.append("</").append(tagName).append(">").append("\n").append(" ");
        }
        return sb.toString();
    }
}