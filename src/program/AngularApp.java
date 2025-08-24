package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AngularApp {
    private final List<AngularFile> angularFiles = new ArrayList<>();

    public void addProgram(AngularFile angularFile) {
        Objects.requireNonNull(angularFile, "program is null");
        this.angularFiles.add(angularFile);
    }

    public List<AngularFile> getPrograms() {
        return Collections.unmodifiableList(angularFiles);
    }

    /** search selector (useful in semantic / generation) */
    public AngularFile findBySelector(String selector) {
        for (AngularFile p : angularFiles) {
            if (p.getSelector().equals(selector)) return p;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AngularApp:\n");
        for (AngularFile p : angularFiles) {
            sb.append("  ").append(p).append("\n");
        }
        return sb.toString();
    }
}
