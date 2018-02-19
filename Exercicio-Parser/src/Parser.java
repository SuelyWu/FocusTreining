import componente.Data;
import componente.Hora;
import componente.Nome;
import configuracao.Configuracao;
import configuracao.FabricaConfiguracao;
import exception.ParserException;

import java.io.*;

public class Parser {

    private BufferedReader reader;
    private Configuracao configuracao;
    private Data data;
    private Hora hora;
    private Nome nome;
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    private void setConfiguracao() {
        try {
            reader = new BufferedReader(new FileReader(file.getName()));
            String a = reader.readLine();
            int i = Integer.parseInt(a);

            FabricaConfiguracao fabricaConfiguracao = new FabricaConfiguracao();
            configuracao = fabricaConfiguracao.getConfiguracao(i);

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (NumberFormatException e) {
            System.out.println("Erro na formatação do arquivo!");
        } catch (ParserException e) {
            System.out.println(e);
        }
    }

    public void executar() {



        configuracao.lerConteudo();
    }

    public void imprimir() {
        configuracao.imprimir();
    }

}
