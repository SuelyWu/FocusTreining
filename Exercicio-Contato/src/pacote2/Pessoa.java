package pacote2;

public class Pessoa {
    private final String name;
    private final int tel;
    private final char inicial;

    public Pessoa(String name, int tel) {
        this.name = name;
        this.tel = tel;
        this.inicial = name.charAt(0);
    }

    public char getInicial() {
        return inicial;
    }

    public String toString() {
        return "Name: " + name + ", Tel: " + tel;
    }
}
