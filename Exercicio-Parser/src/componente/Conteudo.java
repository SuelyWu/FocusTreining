package componente;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Conteudo {

    int qtdColuna = 0;
    int qtdLinha = 0;
    Map<Integer, Map<ComponenteTipo, List>> conteudo;

    public Map getConteudo() {
        return this.conteudo;
    }

    public void addPadrao(int colunaNumber, ComponenteTipo componenteTipo) {
        Map m = new HashMap();
        m.put(componenteTipo, new LinkedList<>());
        conteudo.put(colunaNumber, m);
        qtdColuna++;
        // se conseguir, verificar se compClass eh um componente
    }

    public void addComponente(int colunaNumber, String stringComponente) {
        Map<ComponenteTipo, List> map = conteudo.get(colunaNumber);
        ComponenteTipo c = (ComponenteTipo) map.keySet().toArray()[0];
        List list = map.get(c);
        FabricaComponente fabricaComponente = new FabricaComponente();
        list.add(fabricaComponente.getComponente(c, stringComponente));
        map.put(c, list);
        conteudo.put(colunaNumber, map);

        if (colunaNumber == 1) {
            qtdLinha++;
        }
    }

    public void imprimir() {

        ComponenteTipo c = (ComponenteTipo) conteudo.get(1).keySet().toArray()[0];
        conteudo.get(1).get(c).size();


        for (int i = 0; i < qtdLinha; i++) {
            for (int j = 0; j < qtdColuna; j++) {

            }




        }




    }



}
