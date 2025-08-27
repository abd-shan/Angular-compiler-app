package ast.program;

import ast.component.ProvidersOption;
import ast.html.HtmlDocument;
import ast.ts.statements.TsBlock;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *one ast.component
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
    private final HtmlDocument template;         // null if don't exist
    private final String styles;             // null if don't exist
    private final ProvidersOption providers;
    private final TsBlock tsCode;

    public ComponentFile(String className,
                         String selector,
                         boolean standalone,
                         List<String> componentImports,
                         HtmlDocument template,
                         String styles,
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

    public HtmlDocument getTemplate() {
        return template;
    }

    public String getStyles() {
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
                ", template{\n" + template +'\n'+"} \n"+
                ", styles{\n" + styles +'\n'+"} \n"+
                ", providers{\n" + providers +'\n'+"} \n"+
                ", tsCode{\n" + (tsCode != null ? tsCode.toString() : "null") +'\n'+ "}\n"+
                '}';
    }
}
