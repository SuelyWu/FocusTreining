
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loja {

    private Scanner scanner = new Scanner(System.in);
    private BancoCliente bancoCliente;
    private Armazem armazem;
    private CarrinhoCompra carrinhoCompra;
    private Printer printer;

    public Loja() {
        this.bancoCliente = new BancoCliente();
        this.armazem = new Armazem();
        this.carrinhoCompra = new CarrinhoCompra();
        this.printer = new Printer(System.out);
    }

    public void executar() {
        printer.println("Bem vindo a Loja Virtual");
        printer.println("");
        sessaoVerProd();
    }

    private void sessaoVerProd() {
        printer.printProdutos(armazem.getProdutos());
        int opcao = receberOpcaoValida(2, "Você quer:\n1-Adicionar item\n2-Ver carrinho de compras");
        if (opcao==1) {
            sessaoAddItem();
        } else {
            sessaoVerCarrinho();
        }
    }

    private void sessaoVerCarrinho() {
        printer.printCarrinho(carrinhoCompra.getItens());
        int opcao = receberOpcaoValida(3, "Você quer:\n1-Ver lista produto\n2-Ajustar quantidade de um item\n3-Finalizar compra");
        switch (opcao) {
            case 1: sessaoVerProd();
            case 2: sessaoAjustQtdItem();
            case 3: sessaoFinalizarCompra();
        }
    }

    private void sessaoAddItem() {
        Produto produto = receberProdutoValido();
        int qtd = receberQtdValida();
        ////
        if (armazem.hasProdSuficiente(produto, qtd)) {
            carrinhoCompra.addItem(produto, qtd);
        }
        ////
        sessaoVerCarrinho();
    }

    private void sessaoAjustQtdItem() {
        Produto produto = receberProdutoValido();
        int qtdNova = receberQtdValida();
        carrinhoCompra.ajustItemQtd(produto, qtdNova);
        sessaoVerCarrinho();
    }

    private void sessaoFinalizarCompra() {
        Map argsFinalizacao = new HashMap();
        Cliente cliente = receberClienteValido();
        OpcaoPagamento opcaoPagamento = escolherTipoPag();
        argsFinalizacao.put(Cliente.class, cliente);
        argsFinalizacao.put(OpcaoPagamento.class, opcaoPagamento);
        if (opcaoPagamento.equals(OpcaoPagamento.CARTAO)) {
            argsFinalizacao.putAll(coletaArgPagCartao());
        }

        FinalizadorPedido finalizadorPedido = new FinalizadorPedido(carrinhoCompra, armazem);
        Pedido pedido = finalizadorPedido.finalizar(argsFinalizacao);

        if (opcaoPagamento.equals(OpcaoPagamento.BOLETO)) {
            imprimirBoleto(pedido);
        }
        sessaoVerCarrinho();
    }

    private Cliente receberClienteValido() {
        printer.print("Digite seu id: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (!bancoCliente.hasCliente(id)) {
            printer.print("Erro! Digite seu id novamente: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        return bancoCliente.getClienteById(id);
    }

    private OpcaoPagamento escolherTipoPag() {
        int opcao = receberOpcaoValida(2, "Escolha um tipo de pagamento:\n1-Boleto\n2-Cartão");
        if (opcao==1) return OpcaoPagamento.BOLETO;
        if (opcao==2) return OpcaoPagamento.CARTAO;
        return null;
    }

    private Map coletaArgPagCartao() {
        Map argPagCartao = new HashMap();
        printer.print("Digite o número do cartão: ");
        String numCartao = scanner.nextLine();
        printer.print("Digite a quantidade de parcelas: ");
        int qtdParcelas = Integer.parseInt(scanner.nextLine());
        argPagCartao.put(String.class, numCartao);
        argPagCartao.put(Integer.class, qtdParcelas);
        return argPagCartao;
    }

    private void imprimirBoleto(Pedido pedido) {
        printer.printBoletoCodBarras(pedido.getCodBarras());
    }

    private int receberOpcaoValida(int opcaoMax, String msg) {
        printer.println(msg);

        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {

        }

        while (opcao < 1 || opcao > opcaoMax) {
            printer.println("Opção inválida!");
            printer.println(msg);
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {

            }
        }
        return opcao;
    }

    private Produto receberProdutoValido() {
        printer.print("Digite o nome do produto: ");
        Produto produto = armazem.getProdutoByNome(scanner.nextLine());
        while (produto == null) {
            printer.println("Nome do produto errado!");
            printer.print("Digite o nome do produto: ");
            produto = armazem.getProdutoByNome(scanner.nextLine());
        }
        return produto;
    }

    private int receberQtdValida() {
        printer.print("Digite a quantidade: ");
        String entrada = scanner.nextLine();
        int qtd = 0;
        while (!(qtd >= 1)) {
            try {
                qtd = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                printer.println("Quantidade inválida!");
                printer.print("Digite a quantidade: ");
            }
        }
        return qtd;
    }
}
