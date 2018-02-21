import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PagBoleto extends Pagamento{

    private List<Long> codigoBarras;


    public PagBoleto(final double total) {
        super(total, 1);
        codigoBarras = gerarCodigo(total);
        setOpcaoPagamento(OpcaoPagamento.BOLETO);
    }

    public List gerarCodigo(double total) {
        List codigoBarras = new LinkedList();
        long max10 = Long.valueOf("9999999999");
        long min10 = Long.valueOf("1000000000");
        codigoBarras.add(ThreadLocalRandom.current().nextLong(min10, max10));
        codigoBarras.add(ThreadLocalRandom.current().nextLong(min10, max10));
        codigoBarras.add(ThreadLocalRandom.current().nextLong(min10, max10));
        codigoBarras.add(ThreadLocalRandom.current().nextLong(10));
        long a = ThreadLocalRandom.current().nextLong(1000, 9999);
        codigoBarras.add(a * (long)Math.pow(10, 10) + (long)total * 100);
        return codigoBarras;
    }
}
