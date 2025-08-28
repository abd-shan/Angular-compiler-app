package ast.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AngularApp {
    private final List<AngularFile> angularFiles = new ArrayList<>();

    // ===== add file =====
    public void addFile(AngularFile file) {
        Objects.requireNonNull(file, "AngularFile cannot be null");
        angularFiles.add(file);
    }

    // ===== all files =====
    public List<AngularFile> getFiles() {
        return Collections.unmodifiableList(angularFiles);
    }

    // ===== search ComponentFile by selector =====

    public ComponentFile findComponentBySelector(String selector) {
        for (AngularFile file : angularFiles) {
            if (file instanceof ComponentFile comp && comp.getSelector().equals(selector)) {
                return comp;
            }
        }
        return null;
    }

    // ===== ComponentFiles =====

    public List<ComponentFile> getComponentFiles() {
        return angularFiles.stream()
                .filter(f -> f instanceof ComponentFile)
                .map(f -> (ComponentFile) f)
                .collect(Collectors.toList());
    }

    // ===== StateFiles =====
    public List<StateFile> getStateFiles() {
        return angularFiles.stream()
                .filter(f -> f instanceof StateFile)
                .map(f -> (StateFile) f)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AngularApp:\n");
        for (AngularFile file : angularFiles) {
            sb.append(file).append("\n");
        }
        return sb.toString();
    }
}
