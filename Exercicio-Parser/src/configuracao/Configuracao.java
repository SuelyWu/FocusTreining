package configuracao;

import componente.Conteudo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Configuracao {

    protected Conteudo conteudo;

    public void lerConteudo(List<String> linhasLidas) {
        String s = linhasLidas.get(0);
        conteudo.setIntConfig(1);
        conteudo.setData(s.split("\t")[0]);
        conteudo.setHora(s.split("\t")[1]);
        conteudo.setNome(linhasLidas.get(1));
        for (int i = 2; i < linhasLidas.size(); i++) {
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
