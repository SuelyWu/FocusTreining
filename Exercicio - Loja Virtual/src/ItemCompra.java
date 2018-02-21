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

    public double getTotalItem() {
        return qtd * produto.getPreco();
    }

    public boolean equals(ItemCompra itemCompra) {
        return this.produto.getId() == itemCompra.getIdProduto();
    }

    private int getIdProduto() {
        return this.produto.getId();
    }
}