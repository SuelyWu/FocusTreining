import java.util.List;

public class Compra {

    Cliente cliente;
    List<ItemCompra> itensComprados;
    Pagamento pagamento;

    public Compra(Cliente cliente, List<ItemCompra> itensComprados, Pagamento pagamento) {
        this.cliente = cliente;
        this.itensComprados = itensComprados;
        this.pagamento = pagamento;
    }
}
