package state;
import ts.TypeScript;

import java.util.Objects;

public class StateServiceClass {
    private final InjectableDecorator injectableDecorator; // maybe null
    private final String className;
    private final String tsCode; // AST  TypeScript
    private final boolean isExported;

    public StateServiceClass(InjectableDecorator injectableDecorator, String className, String tsCode, boolean isExported) {
        this.injectableDecorator = injectableDecorator;
        this.className = Objects.requireNonNull(className);
        this.tsCode = tsCode;
        this.isExported = isExported;
    }

    public InjectableDecorator getInjectableDecorator() {
        return injectableDecorator;
    }

    public String getClassName() {
        return className;
    }

    public String getTsCode() {
        return tsCode;
    }

    @Override
    public String toString() {
        return "\n StateServiceClass{" + "\n"+
                "injectableDecorator=" + injectableDecorator +"\n"+
                ", className='" + className + '\'' +"\n"+
                ", isExported='" + isExported + '\'' +"\n"+
                ", tsCode=<ts>" +"\n"+
                '}';
    }
}