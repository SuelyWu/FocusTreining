package configuracao;

import componente.Conteudo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Configuracao {

    protected Conteudo conteudo;

    public Configuracao(){
        conteudo = new Conteudo();
    }

    public void lerConteudo(List<String> linhasLidas) {
        conteudo.setIntConfig(Integer.parseInt(linhasLidas.get(0)));
        String dataHora = linhasLidas.get(1);
        conteudo.setData(dataHora.split("\t")[0]);
        conteudo.setHora(dataHora.split("\t")[1]);
        conteudo.setNome(linhasLidas.get(2));
        for (int i = 3; i < linhasLidas.size(); i++) {
            List<String> linhaAtual = Arrays.asList(linhasLidas.get(i).split("\t"));
            for (int j = 0; j < linhaAtual.size(); j ++) {
                String stringComponente = linhaAtual.get(j);
                conteudo.addComponente(j+1, stringComponente);
            }
        }
    }
    public void imprimir() {
        conteudo.imprimir();
    }
}
