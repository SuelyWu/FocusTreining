import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CodigoBarras {

    private List codigoBarras;

    public CodigoBarras(double total) {
        codigoBarras = new LinkedList();
        codigoBarras.add(getRandomXdig(5) + "." + getRandomXdig(5));
        codigoBarras.add(getRandomXdig(5) + "." + getRandomXdig(5));
        codigoBarras.add(getRandomXdig(5) + "." + getRandomXdig(5));
        codigoBarras.add(getRandomXdig(1));
        codigoBarras.add(getRandom14dig(total));
    }

    private String getRandomXdig(int xDig) {
        int min = (int) Math.pow(10, xDig-1);
        int max = (int) Math.pow(10, xDig);
        return String.valueOf(ThreadLocalRandom.current().nextLong(min, max));
    }

    private String getRandom14dig(double total) {
        BigInteger bigInteger = BigInteger.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
        bigInteger = bigInteger.multiply(new BigInteger("10000000000"));
        bigInteger = bigInteger.add(new BigInteger(String.valueOf((int)(total*100))));
        return String.valueOf(bigInteger);
    }

    public List getCodBarras() {
        return Collections.unmodifiableList(codigoBarras);
    }


}
