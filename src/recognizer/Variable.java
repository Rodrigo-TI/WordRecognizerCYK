package recognizer;
import java.util.ArrayList;
public class Variable {
    // ATRIBUTOS
    private final String name;
    private ArrayList<String> variablesORterminals;
    
    // CONSTRUTOR
    public Variable(String name) {
        this.name = name;
        this.variablesORterminals = new ArrayList();
    }
    
    // GETTERS E SETTERS
    public String getName() {
        return name;
    }
    public ArrayList<String> getVariablesORterminals() {
        return variablesORterminals;
    }
    public void setVariablesORterminals(ArrayList<String> variablesORterminals) {
        this.variablesORterminals = variablesORterminals;
    }
}