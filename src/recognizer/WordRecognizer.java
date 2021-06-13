package recognizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class WordRecognizer {
    // ATTRIBUTES
    private Grammar grammar;
    
    // CONSTRUCTORS
    public WordRecognizer() {
        this.grammar = new Grammar();
    }
    
    // GETTERS AND SETTERS
    public Grammar getGrammar() {
        return grammar;
    }
    
    // METHODS
    public String readAndLoadGrammar(String nameArchive) {
        Grammar newGrammar = new Grammar();
        Scanner s = new Scanner(System.in);
        try {
            FileReader archive = new FileReader(nameArchive);
            BufferedReader reader = new BufferedReader(archive);
            String line = reader.readLine();
            while(line != null) {
                String array[] = line.split(" ");
                if (array.length > 2) {
                    Variable v = new Variable(array[0]);
                    for (int i = 2; i < array.length; i++) {
                        if (!array[i].equals("|")) {
                            v.getVariablesOrTerminals().add(array[i]);
                        }
                    }
                    newGrammar.getProdutions().add(v);
                } else {
                    return "\nA gramática não foi carregada pois existem linhas inválidas no arquivo !\n";
                }
                line = reader.readLine();
            }
            archive.close();
            this.grammar = newGrammar;
        }
        catch (IOException e) {
            return "\nErro na leitura do arquivo !\n";
        }
        return "\nGramática carregada com sucesso !\n";
    }
    public String showGrammar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.grammar.getProdutions().size(); i++) {
            sb.append(this.grammar.getProdutions().get(i).toString()).append("\n");
        }
        return sb.toString();
    }
    public boolean verifyWord(String word) {
        String[] array = word.split("");
        for (int i = 0; i < array.length; i++) {
            if (this.getSymbols(array[i]) == null) {
                return false;
            }
        }
        return this.grammar.getProdutions().isEmpty() ? false : this.algorithmCYK(word);
    }
    private boolean algorithmCYK(String word) {
        // Criando tabela CYK
        ArrayList<String[]> cykTable = new ArrayList();
        for (int i = 1; i < word.length()+1 ; i++) {
            cykTable.add(new String[i]);
        }
        // Percorrendo cada linha da tabela de baixo para cima
        for (int i = cykTable.size()-1; i >= 0; i--) {
            // Percorrendo cada coluna da linha analisada no momento. Lembrando que começa de baixo pra cima
            for (int j = 0; j < cykTable.get(i).length; j++) {
                String currentWord = word.substring(j,((word.length()-1)-i+1+j));
                // Calculando o resultado que deve ser inserido na posição atual
                if (currentWord.length() == 1) {
                    // Inserindo o resultado na posição atual
                    cykTable.get(i)[j] = this.getSymbols(currentWord);
                }
                else {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k+1 < currentWord.length(); k++) {
                        String array1[];
                        String array2[];
                        String wordPart1 = currentWord.substring(0, (k+1));
                        if (wordPart1.length() == 1) {
                            array1 = this.getSymbols(wordPart1).split(",");
                        }
                        else {
                            int index = word.indexOf(wordPart1);
                            String value = cykTable.get(cykTable.size()-1-(wordPart1.length()-1))[index];
                            array1 = value.split(",");
                        }
                        String wordPart2 = currentWord.substring(k+1);
                        if (wordPart2.length() == 1) {
                            array2 = this.getSymbols(wordPart2).split(",");
                        }
                        else {
                            int index = word.indexOf(wordPart2);
                            String value = cykTable.get(cykTable.size()-1-(wordPart2.length()-1))[index];
                            array2 = value.split(",");
                        }
                        for (int l = 0; (array1 != null) && (l < array1.length); l++) {
                            for (int m = 0; (array2 != null) && (m < array2.length); m++) {
                                String value = this.getSymbols(array1[l] + array2[m]);
                                String verificationResult = this.noContainsInStringBuilder(value, sb);
                                if (verificationResult != null) {
                                    sb.append(",").append(verificationResult);
                                }
                            }
                        }
                    }
                    // Inserindo o resultado na posição atual
                    cykTable.get(i)[j] = (sb.length() > 0) ? sb.toString().substring(1) : "-";
                }
            }
        }
        for (int i = 0; i < cykTable.size(); i++) {
            for (int j = 0; j < cykTable.get(i).length; j++) {
                System.out.print(cykTable.get(i)[j] + " ");
            }
            System.out.println("");
        }
        // Validando resultado do algoritmo
        String[] result = cykTable.get(0)[0].split(",");
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals(this.grammar.getProdutions().get(0).getName())) {
                return true;
            }
        }
        return false;
    }
    private String getSymbols(String symbol) {
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < this.grammar.getProdutions().size(); i++) {
            Variable variable = this.grammar.getProdutions().get(i);
            for (int j = 0; j < variable.getVariablesOrTerminals().size(); j++) {
                String variableOrTerminal = variable.getVariablesOrTerminals().get(j);
                if (variableOrTerminal.equals(symbol)) {
                    sb.append(",").append(variable.getName());
                }
            }
        }
        return (sb.length() > 0) ? sb.toString().substring(1) : null;
    }
    private String noContainsInStringBuilder(String symbol, StringBuilder sb) {
        if (sb.length() == 0 || symbol == null) {
            return symbol;
        }
        StringBuilder otherSb = new StringBuilder();
        String[] arraySymbols = symbol.split(",");
        ArrayList<String> arrayListSb = new ArrayList(Arrays.asList(sb.substring(1).split(",")));
        for (int i = 0; i < arraySymbols.length; i++) {
            if (!arrayListSb.contains(arraySymbols[i])) {
                otherSb.append(",").append(arraySymbols[i]);
            }
        }
        return (otherSb.length() > 0) ? otherSb.toString().substring(1) : null;
    }
}