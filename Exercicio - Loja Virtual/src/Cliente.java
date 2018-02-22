import java.util.LinkedList;
import java.util.List;

public class Cliente {

    private final String nome;
    private final int id;
    private List<Pedido> listPedido;

    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id; // numero random de 5 digitos
        listPedido = new LinkedList<>();
    }

    public void addPedido(Pedido pedido) {
        this.listPedido.add(pedido);
    }

    public boolean equals(int id) {
        return this.id == id;
    }
}
