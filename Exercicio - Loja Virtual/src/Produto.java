public class Produto {

    private final ProdutoTipo produtoTipo;
    private final String nome;
    private final double preco;

    public Produto(ProdutoTipo produtoTipo, String nome, final double preco) {
        this.produtoTipo = produtoTipo;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoTipo getProdutoTipo() {
        return produtoTipo;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

}
