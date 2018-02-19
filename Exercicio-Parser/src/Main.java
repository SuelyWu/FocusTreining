import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Parser parser = new Parser();

        while (true) {
            System.out.print("Digite o nome do arquivo a fazer leitura: ");
            String fileName = scanner.nextLine();

            System.out.println();
            parser.setFile(fileName+".txt");
            boolean executou = parser.executar();

            if (executou) {
                System.out.println("\nArquivo imprimido com sucesso!");
            }

            System.out.println("=================================================================");
        }
    }
}