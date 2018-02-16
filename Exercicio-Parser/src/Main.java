import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        File file = new File("testParser.txt");
        Modelo1 modelo1 = new Modelo1(file);
        try {
            modelo1.ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelo1.imprimir();



    }

}


// cada modelo tem seu tipo de compor linha
// um list de linhas