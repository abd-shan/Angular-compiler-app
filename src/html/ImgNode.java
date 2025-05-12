package html;

public class ImgNode extends Html {
    private String property;

    public ImgNode(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }


    @Override
    public String toString() {
        return "img{   " + property + "   }";
    }


}
