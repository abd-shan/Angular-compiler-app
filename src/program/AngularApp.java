package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AngularApp {
    private final List<ComponentFile> componentFiles = new ArrayList<>();

    public void addProgram(ComponentFile componentFile) {
        this.componentFiles.add(componentFile);
    }

    public List<ComponentFile> getPrograms() {
        return Collections.unmodifiableList(componentFiles);
    }

    /** search selector (useful in semantic / generation) */
    public ComponentFile findBySelector(String selector) {
        for (ComponentFile p : componentFiles) {
            if (p.getSelector().equals(selector)) return p;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AngularApp:\n");
        for (ComponentFile p : componentFiles) {
            sb.append("  ").append(p).append("\n");
        }
        return sb.toString();
    }
}
