package ts;

public class Text extends Type{
    private String Text;

    public Text(String stringText) {
        this.Text = stringText;
    }
    public Text() {
        this.Text = "";
    }


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String toString() {
        return " string:"+Text;
    }
}
