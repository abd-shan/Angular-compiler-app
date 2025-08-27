package ast.css;

/**  AST CSS  */
public class InlineStyles implements StylesOption {
    private final String css;

    public InlineStyles(String css) {
        this.css = css!=null? css:"ast.css is null";
    }

    public String getCss() {
        return css;
    }

    @Override
    public String toString() {
        return "InlineStyles{" + css + '}';
    }
}
