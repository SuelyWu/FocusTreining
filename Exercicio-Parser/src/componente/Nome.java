package componente;

public class Nome implements Componente {

    private String nome;

    public Nome (String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
