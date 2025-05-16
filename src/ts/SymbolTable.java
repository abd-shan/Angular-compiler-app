package ts;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    Map<String, Variable> variables;

    public SymbolTable() {
        variables = new HashMap<String, Variable>();
    }

    public Map<String, Variable> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Variable> variables) {
        this.variables = variables;
    }
}
