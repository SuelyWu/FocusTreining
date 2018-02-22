public class ItemPedido {

    private ProdutoTipo produtoTipo;
    private Produto produto;
    private int qtd;

    public ItemPedido(Produto produto, int qtd) {
        this.produto = produto;
        this.produtoTipo = produto.getProdutoTipo();
        this.qtd = qtd;
    }

    public void incrementarQtd() {
        this.qtd++;
    }

    public boolean decrementarQtd(int qtd) {
        int qtdAnterior = this.qtd;
        this.qtd --;
        if (this.qtd < 0) {
            this.qtd = qtdAnterior;
            return false;
        }
        return true;
    }

    public double getProdPreco() {
        return produto.getPreco();
    }

    public String getProdNome() {
        return produto.getNome();
    }

    public int getQtd() {
        return qtd;
    }

    public double getSubtotal() {
        return qtd * produto.getPreco();
    }

    public Produto getProduto() {
        return new Produto(produtoTipo, getProdNome(), getProdPreco());
    }

    public boolean equals(ItemPedido itemPedido) {
        return this.produto.getNome().equalsIgnoreCase(itemPedido.getProdutoNome());
    }

    private String getProdutoNome() {
        return this.produto.getNome();
    }



}