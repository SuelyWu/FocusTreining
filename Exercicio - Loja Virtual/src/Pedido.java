import java.util.LinkedList;
import java.util.List;

public class Pedido {

    Cliente cliente;
    List<ItemPedido> itensComprados;
    Pagamento pagamento;

    public Pedido(Cliente cliente, List<ItemPedido> itensComprados, Pagamento pagamento) {
        this.cliente = cliente;
        this.itensComprados = itensComprados;
        this.pagamento = pagamento;
    }

    public List getCodBarras() {
        if (pagamento.getOpcaoPagamento().equals(OpcaoPagamento.BOLETO)) {
            return ((PagBoleto) pagamento).getCodBarras();
        }
        return new LinkedList();
    }
}
