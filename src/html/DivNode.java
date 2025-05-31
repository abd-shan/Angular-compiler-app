package html;

import html.DivAttribute.DivAttribute;
import html.DivChild.DivChild;

import java.util.List;

public class DivNode extends DivChild{
    public String id;
    public List<DivAttribute> attributes;
    public List<DivChild> children;

    public DivNode(String id, List<DivAttribute> attributes, List<DivChild> children) {
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


    public List<DivAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<DivAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<DivChild> getChildren() {
        return children;
    }

    public void setChildren(List<DivChild> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return
                id +
                ", attributes=" + attributes +
                ", children=" + children
                ;
    }
}
