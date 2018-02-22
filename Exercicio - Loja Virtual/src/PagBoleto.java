import org.omg.PortableServer.THREAD_POLICY_ID;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PagBoleto extends Pagamento{

    private List codigoBarras;


    public PagBoleto(final double total) {
        super(total, 1);
        codigoBarras = gerarCodigo(total);
        setOpcaoPagamento(OpcaoPagamento.BOLETO);
    }

    public List gerarCodigo(double total) {
        List codigoBarras = new LinkedList();
        codigoBarras.add(getRandomXdig(5) + "." + getRandomXdig(5));
        codigoBarras.add(getRandomXdig(5) + "." + getRandomXdig(5));
        codigoBarras.add(getRandomXdig(5) + "." + getRandomXdig(5));
        codigoBarras.add(getRandomXdig(1));
        codigoBarras.add(getRandom14dig(total));
        return codigoBarras;
    }

    private String getRandomXdig(int xDig) {
        int min = (int) Math.pow(10, xDig-1);
        int max = (int) Math.pow(10, xDig);
        return String.valueOf(ThreadLocalRandom.current().nextLong(min, max));

    }

    private String getRandom14dig(double total) {
        BigInteger bigInteger = BigInteger.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
        bigInteger.multiply(new BigInteger("10000000000"));
        bigInteger.add(new BigInteger(String.valueOf(total*100)));
        return String.valueOf(bigInteger);
    }

    public List getCodBarras() {
        return Collections.unmodifiableList(codigoBarras);
    }


    /*
    Codigo de barras eh composto por 5 partes
    00000.00000 00000.00000 00000.00000 0 00000000000000
    parte1      parte2      parte3      4   parte5
    List        List        List



     */
}
