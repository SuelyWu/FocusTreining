import java.util.Collections;
import java.util.List;

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

}
