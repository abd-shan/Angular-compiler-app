package program;

import state.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * يمثل ملف State في Angular
 * يحتوي على:
 *  - import statements
 *  - state interfaces
 *  - state variables
 *  - state actions
 *  - state reducers
 *  - state service classes
 */
public class StateFile {

    private final List<String> importStatements = new ArrayList<>();
    private final List<StateInterface> interfaces = new ArrayList<>();
    private final List<StateVariable> variables = new ArrayList<>();
    private final List<StateAction> actions = new ArrayList<>();
    private final List<StateReducer> reducers = new ArrayList<>();
    private final List<StateServiceClass> serviceClasses = new ArrayList<>();

    // ===== Import Statements =====
    public void addImport(String importStmt) {
        Objects.requireNonNull(importStmt);
        importStatements.add(importStmt);
    }

    public List<String> getImportStatements() {
        return Collections.unmodifiableList(importStatements);
    }

    // ===== Interfaces =====
    public void addInterface(StateInterface iface) {
        Objects.requireNonNull(iface);
        interfaces.add(iface);
    }

    public List<StateInterface> getInterfaces() {
        return Collections.unmodifiableList(interfaces);
    }

    // ===== Variables =====
    public void addVariable(StateVariable var) {
        Objects.requireNonNull(var);
        variables.add(var);
    }

    public List<StateVariable> getVariables() {
        return Collections.unmodifiableList(variables);
    }

    // ===== Actions =====
    public void addAction(StateAction action) {
        Objects.requireNonNull(action);
        actions.add(action);
    }

    public List<StateAction> getActions() {
        return Collections.unmodifiableList(actions);
    }

    // ===== Reducers =====
    public void addReducer(StateReducer reducer) {
        Objects.requireNonNull(reducer);
        reducers.add(reducer);
    }

    public List<StateReducer> getReducers() {
        return Collections.unmodifiableList(reducers);
    }

    // ===== Service Classes =====
    public void addServiceClass(StateServiceClass serviceClass) {
        Objects.requireNonNull(serviceClass);
        serviceClasses.add(serviceClass);
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
        sb.append("Services: ").append(serviceClasses).append("\n");
        return sb.toString();
    }

    // يمكن إضافة وظائف لاحقة: semantic checks أو code generation هنا
}
