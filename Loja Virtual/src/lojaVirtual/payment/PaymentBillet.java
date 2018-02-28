package lojaVirtual.payment;

import java.util.Collections;
import java.util.List;

public class PaymentBillet extends Payment {

    private BarCode barCode;

    public PaymentBillet(final double total) {
        super(PaymentOption.BILLET, total, 1);
        barCode = new BarCode(total);
    }

    public List getBarCode() {
        return Collections.unmodifiableList(barCode.getBarCode());
    }

}
