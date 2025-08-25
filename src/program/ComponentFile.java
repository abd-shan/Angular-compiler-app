package program;

import component.ProvidersOption;
import css.CssOption;
import html.HtmlTemplate;
import ts.TypeScript;
import ts.statements.TsBlock;

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


public class ComponentFile implements AngularFile {
    private final String className;
    private final String selector;
    private final boolean standalone;
    private final List<String> componentImports; // imports: [A,B,...] inside @Component
    private final HtmlTemplate template;         // null if don't exist
    private final CssOption styles;             // null if don't exist
    private final ProvidersOption providers;
    private final TsBlock tsCode;

    public ComponentFile(String className,
                         String selector,
                         boolean standalone,
                         List<String> componentImports,
                         HtmlTemplate template,
                         CssOption styles,
                         ProvidersOption providers,
                         TsBlock tsCode) {

        this.className = Objects.requireNonNull(className, "className is null");
        this.selector = Objects.requireNonNull(selector, "selector is null");
        this.standalone = standalone;
        this.componentImports = componentImports == null
                ? List.of()
                : List.copyOf(componentImports);
        this.template = template; // maybe null
        this.styles = styles;     // maybe null
        this.providers = providers;
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

    public CssOption getStyles() {
        return styles;
    }

    public ProvidersOption getProviders() {
        return providers;
    }

    public TsBlock getTsCode() {
        return tsCode;
    }

    @Override
    public String toString() {
        return "angularFile{" + '\n'+
                "className='" + className + '\'' + '\n'+
                ", selector='" + selector + '\'' +'\n'+
                ", standalone=" + standalone +'\n'+
                ", componentImports=" + componentImports +'\n'+
                ", template=" + template +'\n'+
                ", styles=" + styles +'\n'+
                ", providers=" + providers +'\n'+
                ", tsCode=" + (tsCode != null ? tsCode.toString() : "null") +'\n'+
                '}';
    }
}
