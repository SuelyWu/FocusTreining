public class CreditCard extends PaymentOption {

    private int cardNumber;

    public CreditCard(double totalValue, int timesToPay, int cardNumber) {
        super(PaymentOptionType.CREDITCARD, totalValue);
        this.timesToPay = timesToPay;
        this.cardNumber = cardNumber;
        this.payValueAtTime = getPayValueAtTime();
    }
}
