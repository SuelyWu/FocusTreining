package money;

import exception.CaixaException;
import exception.MoneyInsuficienteException;
import exception.NotaInexistenteException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MoneyHandler {

    private Map<MoneyType, List<Money>> moneyMap;
    private MoneyFlyweight moneyFlyweight;

    public MoneyHandler() {
        moneyFlyweight = new MoneyFlyweight();
        moneyMap = new HashMap<>();
        List<Money> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(moneyFlyweight.getMoney(MoneyType.N100));
        }
        moneyMap.put(MoneyType.N100, list);
        list = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.add(moneyFlyweight.getMoney(MoneyType.N50));
        }
        moneyMap.put(MoneyType.N50, list);
        list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(moneyFlyweight.getMoney(MoneyType.N20));
        }
        moneyMap.put(MoneyType.N20, list);
        list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(moneyFlyweight.getMoney(MoneyType.N10));
        }
        moneyMap.put(MoneyType.N10, list);
    }

    public boolean moneySuficiente(Map<MoneyType, Integer> notasNecessarias) throws CaixaException {
        for (Object nota : MoneyType.values()) {
            if (notasNecessarias.isEmpty() ||
                    !(moneyMap.get(nota).size() >= notasNecessarias.get(nota))) {
                throw new MoneyInsuficienteException();
            }
        }
        return true;
    }

    public void addMoneyMap(Map<MoneyType, Integer> notasParaAdd) throws CaixaException {
        for (MoneyType nota : MoneyType.values()) {
            if (notasParaAdd.isEmpty()) {
                throw new NotaInexistenteException();
            }
            int qtd = notasParaAdd.get(nota);
            List<Money> list = moneyMap.get(nota);
            for(int i = 0; i < qtd; i++) {
                list.add(moneyFlyweight.getMoney(nota));
            }
            moneyMap.put(nota, list);
        }
    }

    public void subMoneyMap(Map<MoneyType, Integer> notasParaSub) {
        for (MoneyType nota : MoneyType.values()) {
            int qtd = notasParaSub.get(nota);
            List<Money> list = moneyMap.get(nota);
            for (int i = 0; i < qtd; i++) {
                list.remove(0);
            }
            moneyMap.put(nota, list);
        }
    }

    public Map<MoneyType, Integer> calcularNotas(double valor) {
        double v = valor;
        Map<MoneyType, Integer> notasNecessarias = new HashMap<>();
        for (MoneyType nota : MoneyType.values()) {
            int qtd = (int) v/nota.toInt();
            v -= qtd*nota.toInt();
            notasNecessarias.put(nota, qtd);
        }
        if (v==0) {
            return notasNecessarias;
        } else {
            return new HashMap<>();
        }
    }

    public void notasDisponiveis() {
        System.out.print("Notas disponíveis: ");
        boolean disponivel = false;
        for (MoneyType moneyType : MoneyType.values()) {
            if ( !moneyMap.get(moneyType).isEmpty() ) {
                disponivel = true;
                System.out.print("R$ " + moneyType.toInt() + ",00   ");
            }
        }
        if (!disponivel) {
            System.out.print("Não há notas disponíveis!");
        }
        System.out.println();
    }

}
