import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BancoCliente {

    private List<Cliente> clientes;

    public BancoCliente() {
        clientes = new LinkedList<>();
        initialize();// add alguns clientes aqui
    }

    public boolean hasCliente(int clienteId) {
        return clientes.stream().filter(c -> c.equals(clienteId)).collect(Collectors.toList()).isEmpty();
    }

    private boolean addCliente(String nome) {
        int id = gerarId();
        if (!hasCliente(id)) {
            clientes.add(new Cliente(nome, id));
            return true;
        }
        return false;
    }

    private int gerarId() {
        Random random = new Random();
        return random.nextInt(89999) + 10000;
    }

    private void initialize(){
        addCliente("Ana");
        addCliente("Beatriz");
        addCliente("Carlos");
        addCliente("Daniel");
    }

}