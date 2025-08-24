package state;
import ts.TypeScript;

import java.util.Objects;

public class StateServiceClass {
    private final InjectableDecorator injectableDecorator; // maybe null
    private final String className;
    private final TypeScript tsCode; // AST  TypeScript

    public StateServiceClass(InjectableDecorator injectableDecorator, String className, TypeScript tsCode) {
        this.injectableDecorator = injectableDecorator;
        this.className = Objects.requireNonNull(className);
        this.tsCode = Objects.requireNonNull(tsCode);
    }

    public InjectableDecorator getInjectableDecorator() {
        return injectableDecorator;
    }

    public String getClassName() {
        return className;
    }

    public TypeScript getTsCode() {
        return tsCode;
    }

    @Override
    public String toString() {
        return "\n StateServiceClass{" + "\n"+
                "injectableDecorator=" + injectableDecorator +"\n"+
                ", className='" + className + '\'' +"\n"+
                ", tsCode=<ts>" +"\n"+
                '}';
    }
}