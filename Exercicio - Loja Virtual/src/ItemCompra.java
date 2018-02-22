public class ItemCompra {
    private Produto produto;
    private int qtd;

    public ItemCompra(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public void incrementarQtd(int qtd) {
        this.qtd += qtd;
    }

    public boolean decrementarQtd(int qtd) {
        int qtdAnterior = this.qtd;
        this.qtd -= qtd;
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

    public boolean equals(ItemCompra itemCompra) {
        return this.produto.getCod() == itemCompra.getCodProduto();
    }

    private int getCodProduto() {
        return this.produto.getCod();
    }


}