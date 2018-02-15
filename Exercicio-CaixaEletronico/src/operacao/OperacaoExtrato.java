package operacao;

import banco.CaixaEletronico;

import java.util.List;
import java.util.Map;

public class OperacaoExtrato extends Operacao {

    //Conta contaAtual = caixaEletronico.getContaAtual();

    @Override
    public boolean operar(Map args) {
        caixaEletronico = (CaixaEletronico) args.get(CaixaEletronico.class);
        List<Operacao> list = caixaEletronico.getContaAtual().getHistorico();
        list.forEach(operacao -> System.out.println(operacao.stringImpressao()));
        System.out.println("Saldo atual: " + caixaEletronico.getContaAtual().getSaldoToString());
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
