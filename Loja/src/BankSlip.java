import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BankSlip extends PaymentOption {

    private List barCode;

    public BankSlip(double totalValue) {
        super(PaymentOptionType.BANKSLIP, totalValue);
        this.timesToPay = 1;
        this.barCode = generateBarCode();
    }

    public List getBarCode() {
        return Collections.unmodifiableList(barCode);
    }

    private List generateBarCode() {
        List list = new LinkedList();
        list.add(getRandomXDig(5) + "." + getRandomXDig(5));
        list.add(getRandomXDig(5) + "." + getRandomXDig(5));
        list.add(getRandomXDig(5) + "." + getRandomXDig(5));
        list.add(getRandomXDig(1));
        list.add(getRandom14dig());
        return list;
    }

    private String getRandomXDig(int xDig) {
        int min = (int) Math.pow(10, xDig-1);
        int max = (int) Math.pow(10, xDig);
        return String.valueOf(ThreadLocalRandom.current().nextLong(min, max));
    }

    private String getRandom14dig() {
        BigInteger bigInteger = BigInteger.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
        bigInteger = bigInteger.multiply(new BigInteger("10000000000"));
        bigInteger = bigInteger.add(new BigInteger(String.valueOf((int)(totalValue*100))));
        return String.valueOf(bigInteger);
    }
}
