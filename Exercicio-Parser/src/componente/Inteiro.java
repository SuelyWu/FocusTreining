package componente;

public class Inteiro implements Componente {

    private int inteiro;

    public Inteiro (String stringInteiro) {
        this.inteiro = Integer.parseInt(stringInteiro);
    }

    @Override
    public String toString() {
        return String.valueOf(inteiro);
    }
}
