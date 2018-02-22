public class Produto {

    private final Categoria categoria;
    private final int codigo;
    private final String nome;
    private final double preco;

    public Produto(Categoria categoria, int codigo, String nome, final double preco) {
        this.categoria = categoria;
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCod() {
        return codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("%s\tR$ %.2f");
    }
}
