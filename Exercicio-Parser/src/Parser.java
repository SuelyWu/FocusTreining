import configuracao.Configuracao;
import configuracao.FabricaConfiguracao;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    private BufferedReader reader;
    private Configuracao configuracao;
    private File file;
    private final String path = "C:/Users/Focusnetworks/IdeaProjects/FocusTreining/Exercicio-Parser/src/";

    public void setFile(String fileName){
        this.file = new File(fileName);
    }

    private int setConfiguracao() {
        try {
            reader = new BufferedReader(new FileReader(path + file.getName()));
            String a = reader.readLine();
            int i = Integer.parseInt(a);

            FabricaConfiguracao fabricaConfiguracao = new FabricaConfiguracao();
            configuracao = fabricaConfiguracao.getConfiguracao(i);

            return i;
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (NumberFormatException e) {
            System.out.println("Configuração inexistente!");
        } catch (ParserException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public boolean executar() {
        List<String> list = new LinkedList<>();
        int intConfig = setConfiguracao();
        list.add(String.valueOf(intConfig));
        if (intConfig != -1) {
            try {
                String str = reader.readLine();
                while (str != null) {
                    list.add(str);
                    str = reader.readLine();
                }
                configuracao.lerConteudo(list);
                configuracao.imprimir();
            } catch (IOException e) {
                System.out.println(e);
            }
            return true;
        }
        return false;
    }
}
