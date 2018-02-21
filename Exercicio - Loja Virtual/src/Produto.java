public class Produto {

    private final Categoria categoria;
    private final int id;
    private final String nome;
    private final double preco;

    public Produto(Categoria categoria, int id, String nome, final double preco) {
        this.categoria = categoria;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s\tR$ %.2f");
    }
}
