package ast.css;

import java.util.Objects;

/**  styleUrl: "..." */
public class ExternalStyle implements StylesOption {
    private final String url;

    public ExternalStyle(String url) {
        this.url = Objects.requireNonNull(url, "url is null");
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ExternalStyle{" + url + '}';
    }
}
