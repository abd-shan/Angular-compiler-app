package html.element;

import html.Node;
import html.attribute.HtmlAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElementNode extends Node {
    private String tagName;
    private List<HtmlAttribute> attributes;
    private List<Node> children;

    public ElementNode(String tagName) {
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public ElementNode(String tagName, List<HtmlAttribute> attributes, List<Node> children) {
        this.tagName = tagName;
        this.attributes = attributes != null ? attributes : new ArrayList<>();
        this.children = children != null ? children : new ArrayList<>();
    }

    public String getTagName() {
        return tagName;
    }

    public void addAttribute(HtmlAttribute attribute) {
        if (attribute != null) {
            attributes.add(attribute);
        }
    }

    public void addChild(Node node) {
        if (node != null) {
            children.add(node);
        }
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }

    public List<Node> getChildren() {
        return children;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);

        if (!attributes.isEmpty()) {
            sb.append(" ");
            sb.append(attributes.stream()
                    .map(HtmlAttribute::toString)
                    .collect(Collectors.joining(" ")));
        }

        if (children.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">");
            sb.append(children.stream()
                    .map(Node::toString)
                    .collect(Collectors.joining("")));
            sb.append("</").append(tagName).append(">");
        }

        return sb.toString();
    }
}