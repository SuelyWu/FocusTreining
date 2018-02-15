package operacao;

import banco.CaixaEletronico;
import banco.Conta;
import exception.CaixaException;
import exception.TransParaSiException;

import java.util.Map;

public class OperacaoTransferencia extends Operacao {

    private double valor;
    private Conta contaDestino;
    private Conta contaAtual;

    @Override
    public boolean operar(Map args) throws CaixaException {
        caixaEletronico = (CaixaEletronico) args.get(CaixaEletronico.class);
        valor = (Double) args.get(Double.class);
        contaDestino = (Conta) args.get(Conta.class);
        contaAtual = caixaEletronico.getContaAtual();
        if (contaAtual.equals(contaDestino)) {
            throw new TransParaSiException();
        }
        if (contaAtual.saldoSuficiente(valor)) {
            addHistorico();
            return true;
        }
        return false;
    }

    @Override
    public double getOperacaoSaldo() {
        return 0;
    }

    @Override
    public String stringImpressao() {
        return null;
    }

    @Override
    public void addHistorico() {
        contaAtual.addHistorico(new OperacaoTransOrigem(valor, contaDestino));
        contaDestino.addHistorico(new OperacaoTransDestino(valor, contaAtual));

    }
}
