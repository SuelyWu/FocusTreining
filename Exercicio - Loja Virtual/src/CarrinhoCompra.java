import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoCompra {

    private List<ItemCompra> itens = new LinkedList<>();

    public void addItem(Produto produto, int qtd) {
        ItemCompra itemAdd = new ItemCompra(produto, qtd);
        List<ItemCompra> matchedItens = itens.stream().filter(item -> item.equals(itemAdd)).collect(Collectors.toList());
        if (matchedItens.isEmpty()) {
            itens.add(itemAdd);
        } else {
            ItemCompra itemCompra = matchedItens.get(0);
            itens.remove(itemCompra);
            itemCompra.incrementarQtd(qtd);
            itens.add(itemCompra);
        }
    }

    public boolean delItem(Produto produto, int qtd) {
        ItemCompra itemDel = new ItemCompra(produto, qtd);
        List<ItemCompra> matchedItens = itens.stream().filter(item -> item.equals(itemDel)).collect(Collectors.toList());
        if (!matchedItens.isEmpty()) {
            ItemCompra itemCompra = matchedItens.get(0);
            ItemCompra itemCompra1 = itemCompra;
            itens.remove(itemCompra);
            if (!itemCompra.decrementarQtd(qtd)) {
                itens.add(itemCompra1);
                return false;
            }
            itens.add(itemCompra);
            return true;
        }
        return false;
    }

    public List<ItemCompra> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getTotalCarrinho() {
         double total = 0;
         for (ItemCompra item : itens) {
             total += item.getTotalItem();
         }
         return total;
    }

    public boolean finalizarCompra(Cliente cliente, Pagamento pagamento) {
        // a implementar
        return false;

    }
}
