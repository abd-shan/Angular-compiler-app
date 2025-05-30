package html;

import html.DivAttribute.DivAttribute;
import html.DivChild.DivChild;

import java.util.List;

public class DivElement extends Div{
    public String id;
    public List<DivAttribute> attributes;
    public List<DivChild> children;

    public DivElement(String id, List<DivAttribute> attributes, List<DivChild> children) {
        this.id = id;
        this.attributes = attributes;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DivElement{" +
                "id='" + id + '\'' +
                ", attributes=" + attributes +
                ", children=" + children +
                '}';
    }
}
