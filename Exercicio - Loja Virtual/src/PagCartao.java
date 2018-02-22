import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PagCartao extends Pagamento {

    private final BigInteger numCartao; // 16 digitos

    public PagCartao(final double total, final int qtdParcela, final BigInteger numCartao) {
        super(total, qtdParcela);
        this.numCartao = numCartao;
        setOpcaoPagamento(OpcaoPagamento.CARTAO);
    }

    public PagCartao(final double total, final int qtdParcela, final String numCartao) {
        super(total, qtdParcela);
        this.numCartao = BigInteger.valueOf(Long.getLong(numCartao));
        setOpcaoPagamento(OpcaoPagamento.CARTAO);
    }
}
