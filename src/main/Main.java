package main;
import java.util.Scanner;
import recognizer.WordRecognizer;
public class Main {
    static void menu() {
        System.out.println("1 - Ler o arquivo texto e carregar gramática");
        System.out.println("2 - Verificar palavra");
        System.out.println("3 - Mostrar gramática carregada");
        System.out.println("0 - Finalizar programa");
        System.out.println("------------------------------------------------");
        System.out.print("Opção escolhida : ");
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        WordRecognizer wr = new WordRecognizer();
        int option = -1;
        while (option != 0) {
            try {
                menu();
                option = Integer.parseInt(s.nextLine());
                switch(option) {
                    case 1:
                        // Ler o arquivo texto e carregar a gramática
                        System.out.println(wr.readAndLoadGrammar("grammar.txt"));
                        break;
                    case 2:
                        // Verificar palavra
                        System.out.print("\nPalavra : ");
                        String palavra = s.nextLine();
                        if (palavra.length() > 0) {
                            if (!wr.getGrammar().getProdutions().isEmpty()) {
                                System.out.println("\nA palavra '" + palavra + "' foi " + (wr.verifyWord(palavra) ? "aceita !\n" : "recusada !\n"));
                            }
                            else {
                                System.out.println("\nA gramática está vazia !\n");
                            }
                        }
                        else {
                            System.out.println("Nenhuma palavra foi informada !\n");
                        }
                        break;
                    case 3:
                        // Mostrar gramática carregada
                        System.out.println("\nGRAMÁTICA :\n" + (wr.showGrammar().length() > 0 ? wr.showGrammar() : "A gramática está vazia !\n"));
                        break;
                    case 0:
                        // Finaliza o programa
                        System.out.println("\nPrograma finalizado !");
                        break;
                    default:
                        // Caso seja escolhido algum número de opção que não existe
                        System.out.println("\nOpção inexistente !\n");
                        break;
                }
            }
            catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("\nOpção inválida !\n");
                }
                else {
                    e.printStackTrace();
                }
            }
        }
    }
}