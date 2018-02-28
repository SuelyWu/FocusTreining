package lojaVirtual;

import lojaVirtual.payment.PaymentOption;

import java.math.BigInteger;

public class OrderFinisherContext {

    private final PaymentOption paymentOption;
    private final double orderTotal;
    private final Client client;
    private BigInteger cardNumber;
    private int timesToPay;

    public OrderFinisherContext(final PaymentOption paymentOption, final double orderTotal, final Client client){
        this.paymentOption = paymentOption;
        this.orderTotal = orderTotal;
        this.client = client;
        this.cardNumber = new BigInteger("0");
        this.timesToPay = 1;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setTimesToPay(int timesToPay) {
        this.timesToPay = timesToPay;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public int getTimesToPay() {
        return timesToPay;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public Client getClient() {
        return client;
    }
}
