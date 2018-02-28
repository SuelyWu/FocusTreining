package lojaVirtual.payment;

import java.math.BigInteger;

public class PaymentCreditCard extends Payment {

    private final BigInteger cardNumber; // 16 digitos

    public PaymentCreditCard(final double total, final int timesToPay, final BigInteger cardNumber) {
        super(PaymentOption.CREDIT_CARD, total, timesToPay);
        this.cardNumber = cardNumber;
}

    public BigInteger getCardNumber() {
        return cardNumber;
    }


}
