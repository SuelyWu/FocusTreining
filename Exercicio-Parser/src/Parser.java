import componente.Data;
import componente.Hora;
import componente.Nome;
import configuracao.Configuracao;
import configuracao.FabricaConfiguracao;
import exception.ParserException;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    private BufferedReader reader;
    private Configuracao configuracao;
    private File file;
    private final String path = "C:/Users/Focusnetworks/IdeaProjects/FocusTreining/Exercicio-Parser/src/";

    public void setFile(String fileName) {
        this.file = new File(fileName);
    }

    private boolean setConfiguracao() {
        try {
            reader = new BufferedReader(new FileReader(path + file.getName()));
            String a = reader.readLine();
            int i = Integer.parseInt(a);

            FabricaConfiguracao fabricaConfiguracao = new FabricaConfiguracao();
            configuracao = fabricaConfiguracao.getConfiguracao(i);

            return true;
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (NumberFormatException e) {
            System.out.println("Erro na formatação do arquivo!");
        } catch (ParserException e) {
            System.out.println(e);
        }
        return false;

    }

    public void executar() {
        List<String> list = new LinkedList<>();
        if (setConfiguracao()) {
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
        }

    }
}
