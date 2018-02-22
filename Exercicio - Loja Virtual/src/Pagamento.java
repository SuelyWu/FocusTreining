import java.util.LinkedList;
import java.util.List;

public class Pagamento {

    private OpcaoPagamento opcaoPagamento;
    private final double total;
    private final int qtdParcela;
    private final List<Double> valorParcelas;



    public Pagamento(final double total, final int qtdParcela) {
        this.total = total;
        this.qtdParcela = qtdParcela;
        this.valorParcelas = calcularValorParcelas();
    }

    private List<Double> calcularValorParcelas() {
        double valorParcela = (double) Math.round(total * 100) / 100;
        double faltaPagar = total;
        List<Double> list = new LinkedList<>();
        for (int i = 0; i < qtdParcela-1; i++) {
            faltaPagar -= valorParcela;
            list.add(valorParcela);
        }
        double diferenca = faltaPagar-valorParcela;
        if (diferenca > 0) {
            list.add(valorParcela + diferenca);
        } else if (diferenca < 0){
            list.add(valorParcela - diferenca);
        } else { // == 0
            list.add(valorParcela);
        }
        return list;
    }

    protected int getQtdParcela() {
        return this.qtdParcela;
    }

    protected void setOpcaoPagamento(OpcaoPagamento opcaoPagamento) {
        this.opcaoPagamento = opcaoPagamento;
    }

    public OpcaoPagamento getOpcaoPagamento() {
        return opcaoPagamento;
    }
}
