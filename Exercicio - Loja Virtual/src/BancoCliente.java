import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BancoCliente {

    private List<Cliente> clientes;

    public BancoCliente() {
        clientes = new LinkedList<>();
        initialize();
    }

    public boolean hasCliente(int clienteId) {
        return !clientes.stream().filter(c -> c.equals(clienteId)).collect(Collectors.toList()).isEmpty();
    }

    public Cliente getClienteById(int clienteId) {
        return clientes.stream().filter(c -> c.equals(clienteId)).collect(Collectors.toList()).get(0);
    }

    private boolean addCliente(String nome, int id) {
        if (!hasCliente(id)) {
            clientes.add(new Cliente(nome, id));
            return true;
        }
        return false;
    }

    private void initialize(){
        addCliente("Ana", 10001);
        addCliente("Beatriz", 10002);
        addCliente("Carlos", 10003);
        addCliente("Daniel", 10004);
    }

}