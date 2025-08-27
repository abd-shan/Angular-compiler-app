package program;

import ast.state.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StateFile implements AngularFile {
    private final List<String> importStatements = new ArrayList<>();
    private final List<StateInterface> interfaces = new ArrayList<>();
    private final List<StateVariable> variables = new ArrayList<>();
    private final List<StateAction> actions = new ArrayList<>();
    private final List<StateReducer> reducers = new ArrayList<>();
    private final List<StateServiceClass> serviceClasses = new ArrayList<>();

    // ===== Import Statements =====
    public void addImport(String importStmt) {
        if (importStmt != null && !importStmt.trim().isEmpty()) {
            importStatements.add(importStmt);
        }
    }

    public List<String> getImportStatements() {
        return Collections.unmodifiableList(importStatements);
    }

    // ===== Interfaces =====
    public void addInterface(StateInterface iface) {
        if (iface != null) {
            interfaces.add(iface);
        }
    }

    public List<StateInterface> getInterfaces() {
        return Collections.unmodifiableList(interfaces);
    }

    // ===== Variables =====
    public void addVariable(StateVariable var) {
        if (var != null) {
            variables.add(var);
        }
    }

    public List<StateVariable> getVariables() {
        return Collections.unmodifiableList(variables);
    }

    // ===== Actions =====
    public void addAction(StateAction action) {
        if (action != null) {
            actions.add(action);
        }
    }

    public List<StateAction> getActions() {
        return Collections.unmodifiableList(actions);
    }

    // ===== Reducers =====
    public void addReducer(StateReducer reducer) {
        if (reducer != null) {
            reducers.add(reducer);
        }
    }

    public List<StateReducer> getReducers() {
        return Collections.unmodifiableList(reducers);
    }

    // ===== Service Classes =====
    public void addServiceClass(StateServiceClass serviceClass) {
        if (serviceClass != null) {
            serviceClasses.add(serviceClass);
        }
    }

    public List<StateServiceClass> getServiceClasses() {
        return Collections.unmodifiableList(serviceClasses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("StateFile:\n");
        sb.append("Imports: ").append(importStatements).append("\n");
        sb.append("Interfaces: ").append(interfaces).append("\n");
        sb.append("Variables: ").append(variables).append("\n");
        sb.append("Actions: ").append(actions).append("\n");
        sb.append("Reducers: ").append(reducers).append("\n");
        sb.append("Services:{\n ").append(serviceClasses).append("}\n");
        return sb.toString();
    }
}