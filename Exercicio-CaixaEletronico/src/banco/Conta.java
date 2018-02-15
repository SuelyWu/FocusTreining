package banco;

import exception.CaixaException;
import exception.SaldoInsuficienteException;
import operacao.Operacao;
import operacao.OperacaoDeposito;
import operacao.OperacaoTipo;

import java.util.*;

public class Conta {

    private final String nome;
    private final int numero;
    private final int digito;
    private Historico historico;

    public Conta(String nome, double saldoInicial, String contaNumber) throws CaixaException {
        this.nome = nome;
        this.historico = new Historico();
        this.numero = Integer.parseInt(contaNumber.split("-")[0]);
        this.digito = Integer.parseInt(contaNumber.split("-")[1]);

        Operacao depositoInicial = new OperacaoDeposito();
        boolean b1 = depositoInicial == null;
        depositoInicial = depositoInicial.getOperacaoConcreta(OperacaoTipo.DEPOSITO);
        b1 = depositoInicial == null;
        Map<Object, Object> args = new HashMap<>();
        args.put(Double.class, saldoInicial);
        args.put(Conta.class, this);
        depositoInicial.operar(args);

        int a = 1;
    }

    public String getNome(){
        return nome;
    }

    public String getSaldoToString() {
        return String.format("R$ %.2f", historico.getSaldo());
    }

    public List<Operacao> getHistorico() {
        return historico.getHistorico();
    }

    public void addHistorico(Operacao operacao) {
        historico.addHistorico(operacao);
    }

    public boolean equals(String outraContaNumber) {
        if (!outraContaNumber.contains("-")) {
            return false;
        }
        int numero = Integer.parseInt(outraContaNumber.split("-")[0]);
        int digito = Integer.parseInt(outraContaNumber.split("-")[1]);
        if (this.numero == numero && this.digito == digito) {
            return true;
        }
        return false;

    }

    public boolean saldoSuficiente(double valor) throws CaixaException {
        if (historico.getSaldo() < valor){
            throw new SaldoInsuficienteException();
        }
        return true;
    }

}
