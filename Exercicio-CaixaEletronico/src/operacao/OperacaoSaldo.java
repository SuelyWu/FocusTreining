package operacao;

import banco.CaixaEletronico;

import java.util.Map;

public class OperacaoSaldo extends Operacao {

    @Override
    public boolean operar(Map args) {
        caixaEletronico = (CaixaEletronico) args.get(CaixaEletronico.class);
        String saldo = caixaEletronico.getContaAtual().getSaldoToString();
        System.out.println(String.format("Saldo atual: %s", saldo));
        return true;
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

    }
}
