package ast.css;

import java.util.Objects;

public class CssOption {
    private final StylesOption option;

    public CssOption(StylesOption option) {
        this.option = Objects.requireNonNull(option, "option is null");
    }

    public StylesOption getOption() {
        return option;
    }

    public boolean isExternal() { return option instanceof ExternalStyle; }
    public boolean isInline()    { return option instanceof InlineStyles; }

    @Override
    public String toString() {
        return "Stylesheet{" + option + '}';
    }
}
