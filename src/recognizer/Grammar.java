package recognizer;
import java.util.ArrayList;
public class Grammar {
    // ATRIBUTOS
    private final ArrayList<Variable> premises;
    
    // CONSTRUTOR
    public Grammar() {
        this.premises = new ArrayList();
    }
    
    // GETTERS E SETTERS
    public ArrayList<Variable> getPremises() {
        return premises;
    }
}