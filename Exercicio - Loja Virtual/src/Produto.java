public class Produto {

    private final ProdutoTipo produtoTipo;
    private final String nomeProduto;
    private final double preco;

    public Produto(final ProdutoTipo produtoTipo, final String nomeProduto, final double preco) {
        this.produtoTipo = produtoTipo;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    public ProdutoTipo getProdutoTipo() {
        return produtoTipo;
    }
}
