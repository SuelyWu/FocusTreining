import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class FinalizadorPedido {

    private CarrinhoCompra carrinhoCompra;
    private Cliente cliente;
    private OpcaoPagamento opcaoPagamento;
    private int qtdParcelas = 0;
    private BigInteger numCartao;
    private Armazem armazem;

    public FinalizadorPedido(CarrinhoCompra carrinhoCompra, Armazem armazem) {
        this.carrinhoCompra = carrinhoCompra;
        this.armazem = armazem;
    }

    public Pedido finalizar(Map args) {
        tratarArgs(args);
        Pagamento pagamento = getPagamento();
        Pedido pedido = new Pedido(cliente, carrinhoCompra.getItens(), pagamento);
        cliente.addPedido(pedido);
        List itens = carrinhoCompra.getItens();
        for (Object obj : itens) {
            Produto produto = ((ItemPedido) obj).getProduto();
            armazem.decrementarProduto(produto, ((ItemPedido) obj).getQtd());
        }
        carrinhoCompra.limparCarrinho();
        return pedido;
    }

    private void tratarArgs(Map args) {
        cliente = (Cliente) args.get(Cliente.class);
        opcaoPagamento = (OpcaoPagamento) args.get(OpcaoPagamento.class);
        if (opcaoPagamento.equals(OpcaoPagamento.CARTAO)) {
            this.qtdParcelas = (int) args.get(Integer.class);
            String stringNumCartao = String.valueOf(args.get(String.class));
            this.numCartao = new BigInteger(stringNumCartao);
        }
    }

    private Pagamento getPagamento() {
        Pagamento pagamento;
        if (opcaoPagamento.equals(OpcaoPagamento.BOLETO)) {
            pagamento = new PagBoleto(carrinhoCompra.getTotalCarrinho());
        } else {
            if (numCartao == null) {
                throw new RuntimeException("Configure primeiro o número de cartão.");
            }
            if (qtdParcelas == 0) {
                throw new RuntimeException("Configure primeiro o número de parcelas.");
            }
            pagamento = new PagCartao(carrinhoCompra.getTotalCarrinho(), qtdParcelas, numCartao);
        }
        return pagamento;
    }

}
