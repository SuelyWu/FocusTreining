import componente.Conteudo;
import componente.Data;
import componente.Hora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        Parser parser = new Parser();
        System.out.print("Digite o nome do arquivo a abrir: ");
        String fileName = scanner.nextLine();

        System.out.println();
        parser.setFile(fileName);
        parser.executar();






    }


}


// cada modelo tem seu tipo de compor linha
// um list de linhas