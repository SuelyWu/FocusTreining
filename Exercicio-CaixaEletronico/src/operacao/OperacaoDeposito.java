package operacao;

import banco.CaixaEletronico;
import banco.Conta;
import exception.CaixaException;

import java.util.Map;

public class OperacaoDeposito extends Operacao {

    private double valor;
    private Conta contaDestino;

    public OperacaoDeposito () {

    }

    @Override
    public boolean operar(Map args) throws CaixaException {
        caixaEletronico = (CaixaEletronico) args.get(CaixaEletronico.class);
        valor = (Double) args.get(Double.class);
        contaDestino = (Conta) args.get(Conta.class);

        if (caixaEletronico != null) { //deposito na maquina
            caixaEletronico.addMoneyMap(valor);
            addHistorico();
        }
        else { // deposito inicial
            addHistorico();
        }
        return true;
    }

    @Override
    public double getOperacaoSaldo() {
        return valor;
    }

    @Override
    public String stringImpressao() {
        if (caixaEletronico == null) {
            return String.format("Depósito inicial: R$ %.2f", valor);
        }
        return String.format("Depósito por %s: R$ %.2f", contaDestino.getNome(), valor);
    }

    @Override
    public void addHistorico() {
        contaDestino.addHistorico(this);
    }




}
