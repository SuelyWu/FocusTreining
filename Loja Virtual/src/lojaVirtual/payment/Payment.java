package lojaVirtual.payment;

public class Payment {

    private PaymentOption paymentOption;
    private final double total;
    private final int timesToPay;

    public Payment(final PaymentOption paymentOption, final double total, final int timesToPay) {
        this.paymentOption = paymentOption;
        this.total = total;
        this.timesToPay = timesToPay;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public int getTimesToPay() {
        return timesToPay;
    }

    public double getValorParcela() {
        return ((double) Math.round(total * 100) / 100)/timesToPay;
    }

}
