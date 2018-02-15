import banco.CaixaEletronico;
import banco.Conta;
import exception.CaixaException;
import exception.ContaInvalidaException;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import operacao.Operacao;
import operacao.OperacaoTipo;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static CaixaEletronico caixaEletronico;

    public static void main(String[] args) throws CaixaException {
        scanner = new Scanner(System.in);

        caixaEletronico = new CaixaEletronico();

        while (true) {
            login();
            System.out.println("\n===============================================\nSeja bem vindo, " + caixaEletronico.getContaAtual().getNome() + "!\n");
            opcao();
        }
    }

    private static void login() {
        boolean login = false;
        System.out.print("Digite o número da sua conta com hífen: ");
        String contaNumber = scanner.nextLine();
        while (!login) {
            try {
                login = caixaEletronico.login(contaNumber);
            } catch (CaixaException e) {
                System.out.print(e + " Digite o número da sua conta com hífen: ");
                contaNumber = scanner.nextLine();
            }
        }
    }

    private static void opcao() throws CaixaException{
        int opcao;
        String str;
        boolean sair = false;
        Map<Object, Object> args;
        while (!sair) {
            caixaEletronico.showOpcao();
            try {
                str = scanner.nextLine();
                opcao = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                continue;
            }
            if (opcao > 6) {
                System.out.println("Opção inválida!");
                continue;
            }
            if (opcao == 6){
                sair = true;
                System.out.println("\n===============================================\n");
            } else {
                OperacaoTipo operacaoTipo = getOperacaoTipo(opcao);
                args = catchArgs(operacaoTipo);
                args.put(OperacaoTipo.class, operacaoTipo);

                try {
                    caixaEletronico.operar(args);
                    if (!operacaoTipo.equals(OperacaoTipo.SALDO) && !operacaoTipo.equals(OperacaoTipo.EXTRATO)) {
                        System.out.println("Operação realizada com sucesso!");
                    }
                } catch (CaixaException e) {
                    System.out.println(e);
                }

            }
            System.out.println();
        }
    }

    private static OperacaoTipo getOperacaoTipo(int opcao) {
        switch (opcao) {
            case 1: return OperacaoTipo.SALDO;
            case 2: return OperacaoTipo.SAQUE;
            case 3: return OperacaoTipo.DEPOSITO;
            case 4: return OperacaoTipo.TRANSFERENCIA;
            case 5: return OperacaoTipo.EXTRATO;
            default: return null;
        }
    }

    private static Map<Object, Object> catchArgs(OperacaoTipo operacaoTipo) throws CaixaException {
        switch (operacaoTipo) {
            case SAQUE:
                return catchValor(operacaoTipo);
            case DEPOSITO:
            case TRANSFERENCIA:
                Map<Object, Object> args = catchValor(operacaoTipo);
                Map map = new HashMap();
                while (map.isEmpty()) {
                    try {
                        map = catchContaDestino(operacaoTipo);
                    } catch (CaixaException e) {
                        System.out.println(e);
                        System.out.println();
                        args = catchValor(operacaoTipo);
                    }
                }
                args.putAll(map);
                return args;
        }
        return new HashMap<>();
    }

    private static Map<Object, Object> catchValor(OperacaoTipo operacaoTipo ) {
        boolean valido = false;
        String str = "";
        Double valor = null;
        if (operacaoTipo.equals(OperacaoTipo.SAQUE)){
            caixaEletronico.notasDisponiveis();
        }
        System.out.print("Digite o valor para " + operacaoTipo + ": R$ ");
        while (!valido) {
            try {
                str = scanner.nextLine();
                valor = Double.valueOf(str);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido!\nDigite o valor para " + operacaoTipo + ": R$ ");
            }
        }
        Map map = new HashMap();
        map.put(Double.class, valor);
        return map;
    }

    private static Map<Object, Object> catchContaDestino(OperacaoTipo operacaoTipo) throws CaixaException {
        String contaDestinoNumber;
        System.out.print("Digite a conta destino para " + operacaoTipo + ", com hífen: ");
        contaDestinoNumber = scanner.nextLine();
        caixaEletronico.validarConta(contaDestinoNumber);
        Map map = new HashMap();
        map.put(Conta.class, caixaEletronico.getContaDaLista(contaDestinoNumber));
        return map;

    }


}
