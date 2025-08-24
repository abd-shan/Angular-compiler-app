package program;

import css.Stylesheet;
import html.HtmlTemplate;
import ts.TypeScript;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *one component
 *  - selector
 *  - standalone?
 *  - imports (inside @Component)
 *  - template (inline or external)
 *  - styles   (inline or external)
 *  - tsCode   (AST )
 *  - className (after class)
 */


public class AngularFile {
    private final String className;
    private final String selector;
    private final boolean standalone;
    private final List<String> componentImports; // imports: [A,B,...] inside @Component
    private final HtmlTemplate template;         // null if don't exist
    private final Stylesheet styles;             // null if don't exist
    private final TypeScript tsCode;

    public AngularFile(String className,
                       String selector,
                       boolean standalone,
                       List<String> componentImports,
                       HtmlTemplate template,
                       Stylesheet styles,
                       TypeScript tsCode) {

        this.className = Objects.requireNonNull(className, "className is null");
        this.selector = Objects.requireNonNull(selector, "selector is null");
        this.standalone = standalone;
        this.componentImports = componentImports == null
                ? List.of()
                : List.copyOf(componentImports);
        this.template = template; // maybe null
        this.styles = styles;     // maybe null
        this.tsCode = Objects.requireNonNull(tsCode, "tsCode is null");
    }

    public String getClassName() {
        return className;
    }

    public String getSelector() {
        return selector;
    }

    public boolean isStandalone() {
        return standalone;
    }

    public List<String> getComponentImports() {
        return Collections.unmodifiableList(componentImports);
    }

    public HtmlTemplate getTemplate() {
        return template;
    }

    public Stylesheet getStyles() {
        return styles;
    }

    public TypeScript getTsCode() {
        return tsCode;
    }

    @Override
    public String toString() {
        return "Program{" +
                "className='" + className + '\'' +
                ", selector='" + selector + '\'' +
                ", standalone=" + standalone +
                ", componentImports=" + componentImports +
                ", template=" + template +
                ", styles=" + styles +
                ", tsCode=" + (tsCode != null ? "<ts>" : "null") +
                '}';
    }
}
