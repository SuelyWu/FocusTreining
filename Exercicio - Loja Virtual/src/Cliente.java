public class Cliente {

    private final String nome;
    private final int id;

    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id; // numero random de 5 digitos
    }

    protected int getId() {
        return this.id;
    }
    // alterar equals

    public boolean equals(int id) {
        return this.id == id;
    }
}
