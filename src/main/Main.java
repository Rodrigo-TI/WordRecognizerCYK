package main;
import recognizer.WordRecognizer;
public class Main {
    public static void main(String[] args) {
        WordRecognizer wr = new WordRecognizer();
        wr.readTextArchive("text.txt");
        
    }
}