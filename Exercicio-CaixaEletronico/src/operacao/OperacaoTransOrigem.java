package operacao;

import banco.Conta;

public class OperacaoTransOrigem extends OperacaoTransferencia {

    double valor;
    Conta contaDestiono;

    public OperacaoTransOrigem (double valor, Conta contaDestiono) {
        this.valor = valor;
        this.contaDestiono = contaDestiono;
    }

    @Override
    public double getOperacaoSaldo() {
        return -valor;
    }

    @Override
    public String stringImpressao() {
        return String.format("Transferência (para %s): R$ %.2f", contaDestiono.getNome(), valor);

    }

}
