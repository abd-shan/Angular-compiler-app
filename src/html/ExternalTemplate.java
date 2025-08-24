package html;

public class ExternalTemplate implements HtmlOption {

    private final String url;

    public ExternalTemplate(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
