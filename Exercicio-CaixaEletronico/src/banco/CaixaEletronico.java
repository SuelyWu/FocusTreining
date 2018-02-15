package banco;

import exception.CaixaException;
import exception.ContaInvalidaException;
import money.MoneyHandler;
import operacao.OperacaoSaldo;
import operacao.OperacaoTipo;
import operacao.Operacao;

import java.util.*;
import java.util.stream.Collectors;

public class CaixaEletronico {

    private List<Conta> contaList;

    private MoneyHandler moneyHandler;
    private Operacao operacao;
    private Conta contaAtual;


    public CaixaEletronico() throws CaixaException {
        moneyHandler = new MoneyHandler();

        operacao = new OperacaoSaldo();

        contaList = new LinkedList<>();
        contaList.add(new banco.Conta("João da Silva", 10854.78,"54125-9"));
        contaList.add(new banco.Conta("Pedro Otávio Magalhães", 1050.99,"25214-8" ));
        contaList.add(new banco.Conta("Maria Green", 7696, "88452-1"));
        contaList.add(new banco.Conta("Stephan Pereira", 412.13,"15935-7"));



    }

    public boolean login(String contaNumber) throws CaixaException {
        try {
            validarConta(contaNumber);
            contaAtual = getContaDaLista(contaNumber);
            return true;
        } catch (CaixaException e) {
            throw e;
        }
    }

    public void showOpcao() {
        String opcoes = "Digite uma das opções:\n" +
                "1-Saldo\n" +
                "2-Saque\n" +
                "3-Depósito\n" +
                "4-Transferência\n" +
                "5-Extrato\n" +
                "6-Sair";
        System.out.println(opcoes);
    }

    public boolean operar(Map<Object, Object> args) throws CaixaException {
        OperacaoTipo operacaoTipo = (OperacaoTipo) args.get(OperacaoTipo.class);
        args.put(CaixaEletronico.class, this);
        operacao = operacao.getOperacaoConcreta(operacaoTipo);
        return operacao.operar(args);
    }

    public boolean validarConta(String contaNumber) throws ContaInvalidaException {
        List list = contaList.stream().filter(conta -> conta.equals(contaNumber)).collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new ContaInvalidaException();
        }
        return true;
    }

    public Conta getContaAtual() {
        return contaAtual;
    }

    public Conta getContaDaLista(String contaNumber) throws CaixaException {
        if (validarConta(contaNumber)) {
            return contaList.stream().filter(conta -> conta.equals(contaNumber)).collect(Collectors.toList()).get(0);
        }
        return null;
    }

    public boolean moneySuficiente(double valor) throws CaixaException {
        return moneyHandler.moneySuficiente(moneyHandler.calcularNotas(valor));
    }

    public void addMoneyMap(double valorParaAdd) throws CaixaException {
        moneyHandler.addMoneyMap(moneyHandler.calcularNotas(valorParaAdd));
    }

    public void subMoneyMap(double valorParaSub) {
        moneyHandler.subMoneyMap(moneyHandler.calcularNotas(valorParaSub));
    }

    public void notasDisponiveis() {
        moneyHandler.notasDisponiveis();
    }
}
