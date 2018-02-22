import org.omg.PortableServer.THREAD_POLICY_ID;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PagBoleto extends Pagamento{

    private CodigoBarras codigoBarras;


    public PagBoleto(final double total) {
        super(total, 1);
        codigoBarras = new CodigoBarras(total);
        setOpcaoPagamento(OpcaoPagamento.BOLETO);
    }

    public List getCodBarras() {
        return Collections.unmodifiableList(codigoBarras.getCodBarras());
    }


    /*
    Codigo de barras eh composto por 5 partes
    00000.00000 00000.00000 00000.00000 0 00000000000000
    parte1      parte2      parte3      4   parte5
    List        List        List



     */
}
