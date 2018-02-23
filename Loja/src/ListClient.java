import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListClient {

    private List<Client> clientList;

    public ListClient() {
        this.clientList = new LinkedList<>();
    }

    public boolean hasClient(Client client) {
        return !clientList.stream().filter(client1 -> client1.equals(client)).collect(Collectors.toList()).isEmpty();
    }

    public boolean hasClient(int id) {
        return !clientList.stream().filter(client -> client.equals(id)).collect(Collectors.toList()).isEmpty();
    }

    private void addClient(Client client) {
        this.clientList.add(client);
    }

    private void generateInicialClients() {
        addClient(new Client("Ana", 1001));
        addClient(new Client("Bianca", 1002));
        addClient(new Client("Carlos", 1003));
        addClient(new Client("Daniel", 1004));
    }


}
