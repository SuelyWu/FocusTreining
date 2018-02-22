import java.util.LinkedList;
import java.util.List;

public class Cliente {

    private final String nome;
    private final int id;
    private List<Pedido> listPedido;

    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id;
        listPedido = new LinkedList<>();
    }

    public void addPedido(Pedido pedido) {
        this.listPedido.add(pedido);
    }

    public boolean equals(int id) {
        return this.id == id;
    }
}
