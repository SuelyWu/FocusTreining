package lojaVirtual;

import lojaVirtual.payment.Payment;
import lojaVirtual.product.ProductHolder;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Client client;
    private List<ProductHolder> purchasedItems;
    private Payment payment;
    private LocalDateTime purchaseDateTime;

    public Order(Client client, List<ProductHolder> purchasedItems, Payment payment) {
        this.client = client;
        this.purchasedItems = purchasedItems;
        this.payment = payment;
        this.purchaseDateTime = LocalDateTime.now();
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public List getPurchasedItems() {
        return purchasedItems;
    }

    public String getClientName() {
        return client.getName();
    }
}
