package operacao;

import banco.CaixaEletronico;
import exception.CaixaException;

import java.util.Map;

public abstract class Operacao {

    CaixaEletronico caixaEletronico;

    public abstract boolean operar(Map args) throws CaixaException;
    public abstract double getOperacaoSaldo();
    public abstract String stringImpressao();
    abstract void addHistorico();

    public Operacao getOperacaoConcreta(OperacaoTipo operacaoTipo) {
        switch (operacaoTipo) {
            case TRANSFERENCIA: return new OperacaoTransferencia();
            case DEPOSITO:      return new OperacaoDeposito();
            case EXTRATO:       return new OperacaoExtrato();
            case SAQUE:         return new OperacaoSaque();
            case SALDO:         return new OperacaoSaldo();
        }
        return null;
   }




}
