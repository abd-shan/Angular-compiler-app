package ast.state;


public class InjectableDecorator {
    private final InjectableOptions options; //maybe null

    public InjectableDecorator(InjectableOptions options) {
        this.options = options;
    }

    public InjectableOptions getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "InjectableDecorator{" +"\n"+
                "options=" + options +"\n"+
                '}';
    }
}
