import java.util.LinkedList;
import java.util.List;

public class Client {

    private final String name;
    private final int id;
    private List<Order> orderList;

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
        this.orderList = new LinkedList<>();
    }

    public boolean equals(Client client) {
        return this.id == client.id;
    }

    public boolean equals(int id) {
        return this.id == id;
    }



}
