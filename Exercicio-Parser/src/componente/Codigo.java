package componente;

public class Codigo implements Componente{
    private String codigo;

    public Codigo (String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return this.codigo;
    }
}
