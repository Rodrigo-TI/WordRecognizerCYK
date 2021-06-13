package recognizer;
import java.util.ArrayList;
public class Grammar {
    // ATTRIBUTES
    private final ArrayList<Variable> produtions;
    
    // CONSTRUCTORS
    public Grammar() {
        this.produtions = new ArrayList();
    }
    
    // GETTERS AND SETTERS
    public ArrayList<Variable> getProdutions() {
        return produtions;
    }
}