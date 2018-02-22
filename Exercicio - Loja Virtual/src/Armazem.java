import java.util.*;

public class Armazem {
    private Map<ProdutoTipo, List<Produto>> armazem;


    public Armazem(){
        armazem = new HashMap<>();
        initialize();
    }

    public Map getProdutos() {
        return Collections.unmodifiableMap(armazem);
    }

    private int getEstoqueProduto(Produto produto) {
        List<Produto> list = armazem.get(produto.getProdutoTipo());
        return list.size();
    }

    public Produto getProdutoByNome(String produtoNome) {
        List listTipoExistente = Arrays.asList(armazem.keySet().toArray());
        for (int i = 0; i < listTipoExistente.size(); i++) {
            ProdutoTipo produtoTipo = (ProdutoTipo)listTipoExistente.get(i);
            List listProd = armazem.get(produtoTipo);
            for (int j = 0; j < listProd.size(); j++) {
                Produto produto = (Produto) listProd.get(j);
                if (produto.getNome().equalsIgnoreCase(produtoNome)) {
                    return produto;
                }
            }
        }
        return null;
    }

    public boolean hasProdSuficiente(Produto produto, int qtdSolicitada) {
        return getEstoqueProduto(produto) >= qtdSolicitada;
    }

    private void initialize() {
        List<Produto> produtoList = new LinkedList<>();
        produtoList.add(new Produto(ProdutoTipo.MESA_REDONDA, "mesa redonda", 300));
        produtoList.add(new Produto(ProdutoTipo.MESA_RETANGULAR, "mesa retangular", 400));
        produtoList.add(new Produto(ProdutoTipo.ROUPA_BRANCA, "camiseta branca", 20));
        produtoList.add(new Produto(ProdutoTipo.ROUPA_PRETA, "camiseta preta", 25));
        for (Produto produto : produtoList) {
            for (int i = 0; i < 20; i++) {
                incrementarProduto(produto);
            }
        }
    }

    private void incrementarProduto(Produto produto) {
        ProdutoTipo produtoTipo = produto.getProdutoTipo();
        List<Produto> list = armazem.get(produtoTipo);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(produto);
        armazem.put(produtoTipo, list);
    }

    public void decrementarProduto(Produto produto, int qtd) {
        ProdutoTipo produtoTipo = produto.getProdutoTipo();

        List<Produto> list = armazem.get(produtoTipo);

        for (int i = 0; i < qtd; i++) {
            list.remove(0);
        }
        armazem.put(produtoTipo, list);

    }

}
