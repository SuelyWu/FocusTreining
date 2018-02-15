package pacote2;

import java.util.LinkedList;
import java.util.List;

public class Contato {
    private List<Pessoa> contato;

    public Contato() {
        contato = new LinkedList<>();
        contato.add(new Pessoa("Laura", 123456789));
        contato.add(new Pessoa("Ana", 12345678));
        contato.add(new Pessoa("Alice", 12345678));
        contato.add(new Pessoa("Julia", 12345678));
        contato.add(new Pessoa("Sofia", 12345678));
        contato.add(new Pessoa("Larissa", 12345678));
        contato.add(new Pessoa("Isabela", 12345678));
        contato.add(new Pessoa("Maria", 12345678));
        contato.add(new Pessoa("Mariana", 12345678));
        contato.add(new Pessoa("Lara", 12345678));
        contato.add(new Pessoa("Leticia", 12345678));
        contato.add(new Pessoa("Valentina", 12345678));
        contato.add(new Pessoa("Amanda", 12345678));
        contato.add(new Pessoa("Luana", 12345678));
        contato.add(new Pessoa("Yasmin", 12345678));
        contato.add(new Pessoa("Sophia", 12345678));
        contato.add(new Pessoa("Ana Maria", 8765321));
        contato.add(new Pessoa("Bia", 123456677));
        contato.add(new Pessoa("Carlos", 123456789));
        contato.add(new Pessoa("Dani", 123456789));
        contato.add(new Pessoa("Lais", 123456789));


    }

    public void recuperar(char inicial) {
        List<Pessoa> matching = new LinkedList<>();
        for(Pessoa p : contato) {
            if(inicial == p.getInicial()) {
                matching.add(p);
            }
        }
        //confluenceit

        matching.forEach(System.out::println);
    }
}
