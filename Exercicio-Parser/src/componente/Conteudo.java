package componente;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Conteudo {

    private int intConfig;
    private Data data;
    private Hora hora;
    private Nome nome;
    private Map<Integer, List<Componente>> conteudo = new HashMap<>();
    private Map<Integer, ComponenteTipo> padrao = new HashMap<>();

    private int qtdColuna = 0;
    private int qtdLinha = 0;

    public void addPadrao(int colunaNumber, ComponenteTipo componenteTipo) {
        padrao.put(colunaNumber, componenteTipo);
        conteudo.put(colunaNumber, new LinkedList<>());
        qtdColuna++;
        // se conseguir, verificar se compClass eh um componente
    }

    public void addComponente(int colunaNumber, String stringComponente) {
        List<Componente> newList = conteudo.get(colunaNumber);
        ComponenteTipo componenteTipo = padrao.get(colunaNumber);
        FabricaComponente fabricaComponente = new FabricaComponente();
        newList.add(fabricaComponente.getComponente(componenteTipo, stringComponente));
        conteudo.put(colunaNumber, newList);

        if (colunaNumber == 1) {
            qtdLinha++;
        }
    }

    public void imprimir() {
        System.out.println(intConfig);
        System.out.println(data + "\t" + hora);
        System.out.println(nome);

        for (int linhaAtual = 0; linhaAtual < qtdLinha; linhaAtual++) {
            for (int colunaAtual = 0; colunaAtual < qtdColuna; colunaAtual++) {
                List<Componente> listColunaAtual = conteudo.get(colunaAtual+1);
                Componente compAtual = listColunaAtual.get(linhaAtual);
                System.out.print(compAtual);
                if (colunaAtual == qtdColuna-1) {
                    System.out.println();
                } else {
                    System.out.print("\t");
                }
            }
        }
    }

    public void setIntConfig(int intConfig) {
        this.intConfig = intConfig;
    }

    public void setData(String stringData) {
        this.data = new Data(stringData);
    }

    public void setHora(String stringHora) {
        this.hora = new Hora(stringHora);
    }

    public void setNome(String stringNome) {
        this.nome = new Nome(stringNome);
    }

}
