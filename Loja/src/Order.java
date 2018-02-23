import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private final Client client;
    private final List<Product> productList;
    private final PaymentOption paymentOption;
    private final LocalDateTime dateTime;

    public Order(Client client, List productList, PaymentOption paymentOption) {
        this.client = client;
        this.productList = productList;
        this.paymentOption = paymentOption;
        this.dateTime = LocalDateTime.now();
    }




}
