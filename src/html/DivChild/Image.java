package html.DivChild;

public class Image extends DivChild{
    public String id;
    public String attribute;
    public Image(String id, String attribute) {
        this.id = id;
        this.attribute = attribute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", attribute='" + attribute + '\'' +
                '}';
    }
}
