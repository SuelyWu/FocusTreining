import componente.*;
import componente.Double;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modelo1 {

    ModeloTipo modeloTipo = ModeloTipo.MODELO1;
    Data data;
    Hora hora;
    Nome nome;
    File file;

    // definir como compoe uma linha (as colunas, componentes de uma linha)
    // int double data codigo int
    Map<Integer, List> conteudo;
    // Map<Integer, Map<ComponenteTipo, List<Componente>> conteudo
    int qtdColunas = 5;
    int qtdLinhas = 0;

    public Modelo1 (File file) {
        this.file = file;
        conteudo = new HashMap<>();
        conteudo.put(1, new LinkedList<Inteiro>());
        conteudo.put(2, new LinkedList<Double>());
        conteudo.put(3, new LinkedList<Data>());
        conteudo.put(4, new LinkedList<Codigo>());
        conteudo.put(5, new LinkedList<Inteiro>());
    }

    public void ler () throws IOException{
        // processar as linhas do arquivo
        BufferedReader reader = new BufferedReader(new FileReader(this.file.getName()));
        String tipo = reader.readLine();
        String dataHora = reader.readLine();
        this.data = new Data(dataHora.split("\t")[0]);
        this.hora = new Hora(dataHora.split("\t")[1]);
        String nome = reader.readLine();
        this.nome = new Nome(nome);

        String linhaAtual = reader.readLine();

        while (linhaAtual != null && !linhaAtual.equals("\n")) {
            qtdLinhas++;
            String[] linha = linhaAtual.split("\t");
            List list = conteudo.get(1);
            list.add(new Inteiro(linha[0]));
            conteudo.put(1, list);

            list.getClass();

            list = conteudo.get(2);
            list.add(new Double(linha[1]));
            conteudo.put(2, list);
            list = conteudo.get(3);
            list.add(new Data(linha[2]));
            conteudo.put(3, list);
            list = conteudo.get(4);
            list.add(new Codigo(linha[3]));
            conteudo.put(4, list);
            list = conteudo.get(5);
            list.add(new Inteiro(linha[4]));
            conteudo.put(5, list);
            linhaAtual = reader.readLine();
        }




    }

    public void imprimir() {
        // imprimir os dados coletados

        System.out.println("1");
        System.out.println(data + "\t" + hora);
        System.out.println(nome);
        for (int i = 0; i < qtdLinhas; i++){
            for (int j = 0; j < qtdColunas; j++) {
                List list = conteudo.get(j+1);
                System.out.print(list.get(i));
                if (j != qtdColunas - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }



}
