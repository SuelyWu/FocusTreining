package operacao;

import banco.CaixaEletronico;
import banco.Conta;
import exception.CaixaException;

import java.util.Map;

public class OperacaoSaque extends Operacao {

    private double valor;
    private Conta contaAtual;

    @Override
    public boolean operar(Map args) throws CaixaException {
        caixaEletronico = (CaixaEletronico) args.get(CaixaEletronico.class);
        valor = (Double) args.get(Double.class);
        contaAtual = caixaEletronico.getContaAtual();




        if ( caixaEletronico.getContaAtual().saldoSuficiente(valor) &&
                caixaEletronico.moneySuficiente(valor) ) {
            caixaEletronico.subMoneyMap(valor);
            addHistorico();
            return true;
        }
        return false;
    }

    @Override
    public double getOperacaoSaldo() {
        return -valor;
    }

    @Override
    public void addHistorico() {
        contaAtual.addHistorico(this);
    }

    public  String stringImpressao() {
        return String.format("Saque: R$ %.2f", valor);
    }

}
