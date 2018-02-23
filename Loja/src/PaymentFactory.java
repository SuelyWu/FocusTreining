import java.util.Map;

public class PaymentFactory {

    public static PaymentOption getPaymentConcrete(Map args) {
        PaymentOptionType type = (PaymentOptionType) args.get(PaymentOptionType.class);
        int cardNumber = Integer.parseInt((String) args.get(String.class));
        int timesToPay = (Integer) args.get(Integer.class);
        double totalValue = (Double) args.get(Double.class);

        switch (type) {
            case BANKSLIP:
                return new BankSlip(totalValue);
            case CREDITCARD:
                return new CreditCard(totalValue, timesToPay, cardNumber);
            default:
                return null;
        }


    }
}
