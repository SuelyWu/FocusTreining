import java.util.LinkedList;
import java.util.List;

public class PagCartao extends Pagamento {

    private final List numCartao; // 16 digitos

    public PagCartao(final double total, final int qtdParcela, final String strNumeroCartao) {
        super(total, qtdParcela);
        this.numCartao = strToNumCartao(strNumeroCartao);
        setOpcaoPagamento(OpcaoPagamento.CARTAO);
    }

    private List strToNumCartao(String strNumeroCartao) {
        String parte1 = strNumeroCartao.substring(0, 4);
        String parte2 = strNumeroCartao.substring(4, 8);
        String parte3 = strNumeroCartao.substring(8, 12);
        String parte4 = strNumeroCartao.substring(12);
        List<Integer> list = new LinkedList<>();
        list.add(Integer.parseInt(parte1));
        list.add(Integer.parseInt(parte2));
        list.add(Integer.parseInt(parte3));
        list.add(Integer.parseInt(parte4));
        return list;
    }
}
