package css;

import java.util.Objects;

/**  AST CSS  */
public class InlineStyles implements StylesOption {
    private final Css css;

    public InlineStyles(Css css) {
        this.css = Objects.requireNonNull(css, "css is null");
    }

    public Css getCss() {
        return css;
    }

    @Override
    public String toString() {
        return "InlineStyles{" + css + '}';
    }
}
