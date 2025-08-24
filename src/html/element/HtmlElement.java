package html.element;

import html.HtmlNode;
import html.attribute.HtmlAttribute;

import java.util.ArrayList;
import java.util.List;

public class HtmlElement implements HtmlNode {
    private String tagName;                        // مثل div, input
    private List<HtmlAttribute> attributes;        // جميع الخصائص
    private List<Object> children;                 // node: HtmlElement, Interpolation, TextNode

    public HtmlElement(String tagName) {
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addAttribute(HtmlAttribute attribute) {
        attributes.add(attribute);
    }

    public void addChild(Object child) {
        children.add(child);
    }

    // Getters & Setters

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<HtmlAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "HtmlElement{" +
                "tagName='" + tagName + '\'' +
                ", attributes=" + attributes +
                ", children=" + children +
                '}';
    }
}
