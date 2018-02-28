package lojaVirtual;

import lojaVirtual.database.Store;
import lojaVirtual.payment.*;
import lojaVirtual.product.Product;
import lojaVirtual.product.ProductHolder;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderFinisher {

    private Store store;
    private ShoppingCart shoppingCart;
    private Client client;
    private PaymentOption paymentOption;
    private int timesToPay = 0;
    private BigInteger cardNumber;

    public OrderFinisher(ShoppingCart shoppingCart, Store store) {
        this.shoppingCart = shoppingCart;
        this.store = store;
    }

    public Order finishOrder(OrderFinisherContext context) {
        Payment payment = getPayment(context);
        Order order = new Order(client, shoppingCart.getItems(), payment);
        client.addOrder(order);
        List<ProductHolder> items = shoppingCart.finishOrder();
        for (ProductHolder holder : items) {
            Product product = holder.getProduct();
            store.decreaseProduct(product, holder.getQtt());
        }
        return order;
    }

    private Payment getPayment(OrderFinisherContext context) {
        client = context.getClient();
        paymentOption = context.getPaymentOption();
        timesToPay = context.getTimesToPay();
        cardNumber = context.getCardNumber();
        PaymentFactory paymentFactory = new PaymentFactory();
        return paymentFactory.getPayment(context);
    }

}
