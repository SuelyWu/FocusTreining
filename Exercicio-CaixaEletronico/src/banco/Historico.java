package banco;

import operacao.Operacao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Historico {

    private List<Operacao> historico;

    public Historico() {
        this.historico = new LinkedList<>();
    }

    public void addHistorico(Operacao operacao) {
        historico.add(operacao);
    }

    public List<Operacao> getHistorico() {
        return Collections.unmodifiableList(historico);
    }

    public double getSaldo() {
        return historico
                .stream()
                .mapToDouble(Operacao::getOperacaoSaldo)
                .sum();
    }
}
