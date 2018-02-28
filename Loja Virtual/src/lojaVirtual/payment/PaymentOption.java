package lojaVirtual.payment;

public enum PaymentOption {
    BILLET, CREDIT_CARD;

    @Override
    public String toString() {
        switch (this) {
            case BILLET: return "Billet";
            case CREDIT_CARD: return "Credit Card";
                default: return "undefined";
        }
    }
}
