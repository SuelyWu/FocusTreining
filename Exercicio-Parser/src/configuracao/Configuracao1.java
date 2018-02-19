package configuracao;

import componente.*;
import java.util.*;

public class Configuracao1 implements Configuracao {

    private Conteudo conteudo;
    // definir como compoe uma conteudo (as colunas, componentes de uma conteudo)
    // int double data codigo int
    //Map<Integer, List> conteudo;
    // Map<Integer, Map<ComponenteTipo, List<Componente>> conteudo

    public Configuracao1() {
        conteudo = new Conteudo();
        conteudo.addPadrao(1, ComponenteTipo.INTEIRO);
        conteudo.addPadrao(2, ComponenteTipo.DOUBLE);
        conteudo.addPadrao(3, ComponenteTipo.DATA);
        conteudo.addPadrao(4, ComponenteTipo.CODIGO);
        conteudo.addPadrao(5, ComponenteTipo.INTEIRO);
    }

    @Override
    public void lerConteudo(List<String> linhasLidas){
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
