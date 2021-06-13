package recognizer;
import java.util.ArrayList;
public class Variable {
    // ATTRIBUTES
    private final String name;
    private ArrayList<String> variablesOrTerminals;
    
    // CONSTRUCTORS
    public Variable(String name) {
        this.name = name;
        this.variablesOrTerminals = new ArrayList();
    }
    
    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public ArrayList<String> getVariablesOrTerminals() {
        return variablesOrTerminals;
    }
    public void setVariablesOrTerminals(ArrayList<String> variablesOrTerminals) {
        this.variablesOrTerminals = variablesOrTerminals;
    }
    
    // METHODS
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name);
        if (this.variablesOrTerminals.isEmpty()) {
            sb.append(" => ");
        } else {
            sb.append(" => ").append(this.variablesOrTerminals.get(0));
        }
        for (int i = 1; i < this.variablesOrTerminals.size(); i++) {
            sb.append(" ").append("|").append(" ").append(this.variablesOrTerminals.get(i));
        }
        return sb.toString();
    }
}