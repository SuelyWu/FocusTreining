import configuracao.Configuracao1;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        File file = new File("testParser.txt");
        Configuracao1 configuracao1 = new Configuracao1();
        try {
            configuracao1.ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuracao1.imprimir();



    }

}


// cada modelo tem seu tipo de compor linha
// um list de linhas