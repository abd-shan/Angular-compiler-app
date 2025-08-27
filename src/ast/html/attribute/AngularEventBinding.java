package ast.html.attribute;

// Event Binding
public class AngularEventBinding extends HtmlAttribute {
    private String event;
    private String handler;

    public AngularEventBinding(String event, String handler) {
        this.event = event != null ? event : "";
        this.handler = handler != null ? handler : "";
    }

    @Override
    public String getName() {
        return "(" + event + ")";
    }

    @Override
    public String getValue() {
        return handler;
    }

    public String getEvent() {
        return event;
    }

    public String getHandler() {
        return handler;
    }


    @Override
    public String toString() {
        return "(" + event + ")=\"" + handler + "\"";
    }
}