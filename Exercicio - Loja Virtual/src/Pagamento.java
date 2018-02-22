public class Pagamento {

    private OpcaoPagamento opcaoPagamento;
    private final double total;
    private final int qtdParcela;
    private final double valorParcelas;

    public Pagamento(final double total, final int qtdParcela) {
        this.total = total;
        this.qtdParcela = qtdParcela;
        this.valorParcelas = calcularValorParcelas();
    }

    public OpcaoPagamento getOpcaoPagamento() {
        return opcaoPagamento;
    }

    protected void setOpcaoPagamento(OpcaoPagamento opcaoPagamento) {
        this.opcaoPagamento = opcaoPagamento;
    }

    private double calcularValorParcelas() {
        return (double) Math.round(total * 100) / 100;
    }

}
