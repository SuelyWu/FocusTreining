import java.util.*;

public class Armazem {
    private Map<Categoria, Map<Integer, List<Produto>>> armazem;


    public Armazem(){
        armazem = new HashMap<>();
        initialize();
    }

    public Map getProdutos() {
        return Collections.unmodifiableMap(armazem);
    }

    private Map getProdEmCategoria(Produto produto) {
        Map map = armazem.get(produto.getCategoria());
        if (map == null) {
            map = new HashMap();
        }
        return map;
    }

    private int getEstoqueProduto(Produto produto) {
        Map<Integer, List<Produto>> map = armazem.get(produto.getCategoria());
        List<Produto> list = map.get(produto.getCod());
        return list.size();
    }

    public void decrementarProduto(Produto produto) {
        Categoria categoria = produto.getCategoria();
        int cod = produto.getCod();
        Map<Integer, List<Produto>> map = armazem.get(categoria);
        List<Produto> list = map.get(cod);
        if (list != null) {
            list.remove(produto);
            map.put(cod, list);
            armazem.put(categoria, map);
        }
    }

    private void incrementarProduto(Produto produto) {
        Categoria categoria = produto.getCategoria();
        int cod = produto.getCod();
        Map<Integer, List<Produto>> map = armazem.get(categoria);
        List<Produto> list = map.get(cod);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(produto);
        map.put(cod, list);
        armazem.put(categoria, map);
    }



    public boolean hasProdSuficiente(Produto produto, int qtdSolicitada) {
        return getEstoqueProduto(produto) >= qtdSolicitada;
    }

    private void initialize() {
        List<Produto> produtoList = new LinkedList<>();
        produtoList.add(new Produto(Categoria.MOVEL, 1001, "mesa redonda", 300));
        produtoList.add(new Produto(Categoria.MOVEL, 1002, "mesa retangular", 400));
        produtoList.add(new Produto(Categoria.ROUPA, 2001, "camiseta branca", 20));
        produtoList.add(new Produto(Categoria.ROUPA, 2002, "camiseta preta", 20));
        for (Produto produto : produtoList) {
            for (int i = 0; i < 20; i++) {
                incrementarProduto(produto);
            }
        }
    }


}
