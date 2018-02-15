package operacao;

import banco.Conta;

public class OperacaoTransDestino extends OperacaoTransferencia {

    double valor;
    Conta contaOrigem;

    public OperacaoTransDestino (double valor, Conta contaOrigem) {
        this.valor = valor;
        this.contaOrigem = contaOrigem;
    }

    @Override
    public double getOperacaoSaldo() {
        return valor;
    }

    @Override
    public String stringImpressao() {
        return String.format("Transferência (de %s): R$ %.2f", contaOrigem.getNome(), valor);
    }

}
