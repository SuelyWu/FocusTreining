public abstract class PaymentOption {

    double totalValue;
    PaymentOptionType paymentOptionType;
    int timesToPay;
    double payValueAtTime;


    public PaymentOption(PaymentOptionType paymentOptionType, double totalValue) {
        this.totalValue = totalValue;
        this.paymentOptionType = paymentOptionType;
    }

    public double getPayValueAtTime() {
        return Math.round(totalValue / timesToPay);
    }



}
