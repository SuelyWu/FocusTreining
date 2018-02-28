package lojaVirtual.payment;

import lojaVirtual.OrderFinisherContext;

public class PaymentFactory {

    public Payment getPayment(OrderFinisherContext context) {
        PaymentOption paymentOption = context.getPaymentOption();
        switch (paymentOption) {
            case CREDIT_CARD:
                return new PaymentCreditCard(
                        context.getOrderTotal(),
                        context.getTimesToPay(),
                        context.getCardNumber()
                );
            case BILLET:
                return new PaymentBillet(context.getOrderTotal());

                default: throw new RuntimeException("Error in PaymentFactory -> have not paymentOption");
        }
    }

}
