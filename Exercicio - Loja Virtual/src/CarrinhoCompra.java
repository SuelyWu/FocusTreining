import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarrinhoCompra {

    private List<ItemPedido> itens = new LinkedList<>();

    public void ajustItemQtd(Produto produto, int qtdNova) {
        ItemPedido itemPedido = new ItemPedido(produto, qtdNova);
        List<ItemPedido> matchedItens = itens.stream().filter(item -> item.equals(itemPedido)).collect(Collectors.toList());
        ItemPedido itemAntigo = matchedItens.get(0);
        if (itemAntigo.getQtd() < qtdNova) {
            addItem(produto, qtdNova - itemAntigo.getQtd());
        } else {
            delItem(produto, itemAntigo.getQtd() - qtdNova);
        }
    }

    public void addItem(Produto produto, int qtd) {
        ItemPedido itemAdd = new ItemPedido(produto, qtd);
        List<ItemPedido> matchedItens = itens.stream().filter(item -> item.equals(itemAdd)).collect(Collectors.toList());
        if (matchedItens.isEmpty()) {
            itens.add(itemAdd);
        } else {
            ItemPedido itemPedido = matchedItens.get(0);
            itens.remove(itemPedido);
            for (int i = 0; i < qtd; i++) {
                itemPedido.incrementarQtd();
            }
            itens.add(itemPedido);
        }
    }

    public boolean delItem(Produto produto, int qtd) {
        ItemPedido itemDel = new ItemPedido(produto, qtd);
        List<ItemPedido> matchedItens = itens.stream().filter(item -> item.equals(itemDel)).collect(Collectors.toList());
        if (!matchedItens.isEmpty()) {
            ItemPedido itemPedido = matchedItens.get(0);
            ItemPedido itemPedido1 = itemPedido;
            itens.remove(itemPedido);
            if (!itemPedido.decrementarQtd(qtd)) {
                itens.add(itemPedido1);
                return false;
            }
            itens.add(itemPedido);
            return true;
        }
        return false;
    }

    public List getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getTotalCarrinho() {
         double total = 0;
         for (ItemPedido item : itens) {
             total += item.getSubtotal();
         }
         return total;
    }

    public void limparCarrinho() {
        this.itens = new LinkedList<>();
    }
}
