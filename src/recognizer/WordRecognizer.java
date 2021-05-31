package recognizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class WordRecognizer {
    // ATRIBUTOS
    private final Grammar grammar;
    
    // CONSTRUTOR
    public WordRecognizer() {
        this.grammar = new Grammar();
    }
    
    // GETTER E SETTERS
    public Grammar getGrammar() {
        return grammar;
    }
    
    // MÉTODOS
    public void readTextArchive(String nameArchive) {
        Scanner s = new Scanner(System.in);
        try {
            FileReader archive = new FileReader(nameArchive);
            BufferedReader reader = new BufferedReader(archive);
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);
                
                String nameVariable = line.substring(0, 1);
                Variable v = new Variable(nameVariable);
                line = line.substring(5).replaceAll(" ","");

                while(line != null) {
                    int indice = line.indexOf("|");
                    
                }
                
                this.getGrammar().getPremises().add(v);
                line = reader.readLine();
            }
            archive.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}