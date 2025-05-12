package html;

import java.util.List;

public class DivNode extends Html {
    private String id;
    private String classValue;
    private String directive; // *ngIf, *ngFor
    private String event;
    private List<Html> children;

    public DivNode(String id, String classValue, String directive, String event, List<Html> children) {
        this.id = id;
        this.classValue = classValue;
        this.directive = directive;
        this.event=event;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public String getClassValue() {
        return classValue;
    }

    public String getDirective() {
        return directive;
    }

    public String getEvent() {
        return event;
    }

    public List<Html> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("div{   ");
        if (id != null) sb.append(" id=\"").append(id).append("\"");
        if (classValue != null) sb.append(" class=\"").append(classValue).append("\"");
        if (directive != null) sb.append(" ").append(directive);
        if (event != null) sb.append(" ").append(event);

        if (children != null && !children.isEmpty()) {
            for (Html child : children) {
                sb.append("  ").append(child.toString().replace("\n", "\n  ")).append("\n");
            }
        }

        sb.append("   }");
        return sb.toString();
    }

}
