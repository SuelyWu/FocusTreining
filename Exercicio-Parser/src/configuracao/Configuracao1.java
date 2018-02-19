package configuracao;

import componente.*;
import componente.Double;

import java.io.*;
import java.util.*;

public class Configuracao1 implements Configuracao {

    private Data data;
    private Hora hora;
    private Nome nome;
    private Conteudo conteudo;
    // definir como compoe uma conteudo (as colunas, componentes de uma conteudo)
    // int double data codigo int
    //Map<Integer, List> conteudo;
    // Map<Integer, Map<ComponenteTipo, List<Componente>> conteudo

    public Configuracao1() {
        conteudo.addPadrao(1, ComponenteTipo.INTEIRO);
        conteudo.addPadrao(2, ComponenteTipo.DOUBLE);
        conteudo.addPadrao(3, ComponenteTipo.DATA);
        conteudo.addPadrao(4, ComponenteTipo.CODIGO);
        conteudo.addPadrao(5, ComponenteTipo.INTEIRO);

    }

    @Override
    public void lerConteudo(List<String> list) throws IOException{
        String s = list.get(1);
        data = new Data(s.split("\t")[0]);
        hora = new Hora(s.split("\t")[1]);
        nome = new Nome(list.get(2));
        for (int i = 3; i < list.size(); i++) {
            List<String> linhaAtual = Arrays.asList(list.get(i).split("\t"));
            for (int j = 0; j < linhaAtual.size(); j ++) {
                String stringComponente = linhaAtual.get(j);
                conteudo.addComponente(j, stringComponente);
            }
        }
    }

    public void imprimir() {
        // imprimir os dados coletados

        System.out.println("1");
        System.out.println(data + "\t" + hora);
        System.out.println(nome);
        conteudo.imprimir();

    }



}
