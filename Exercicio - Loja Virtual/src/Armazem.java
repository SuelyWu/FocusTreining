import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Armazem {
    private Map<ProdutoTipo, List<Produto>> armazem;

    public Armazem(){
        armazem = new HashMap<>();
    }

    public void decrementarProduto(ProdutoTipo produtoTipo) {
        List<Produto> produtoList = armazem.get(produtoTipo);
        produtoList.remove(0);
        armazem.put(produtoTipo, produtoList);
    }

    public void incrementarProduto(Produto produto) {
        ProdutoTipo produtoTipo = produto.getProdutoTipo();
        List<Produto> produtoList = armazem.get(produtoTipo);
        produtoList.add(produto);
        armazem.put(produtoTipo, produtoList);
    }

    public List getListaProdutos() {
        List lists = new LinkedList<>();
        for (ProdutoTipo tipo : ProdutoTipo.values()) {
            List listProduto = armazem.get(tipo);
            lists.addAll(listProduto);
        }
        return lists;
    }



}
