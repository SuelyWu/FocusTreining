package configuracao;

import componente.ComponenteTipo;
import componente.Conteudo;

import java.util.Arrays;
import java.util.List;

public class Configuracao2 extends Configuracao {

    private Conteudo conteudo;

    public Configuracao2() {
        conteudo = new Conteudo();
        conteudo.addPadrao(1, ComponenteTipo.NOME);
        conteudo.addPadrao(2, ComponenteTipo.INTEIRO);
        conteudo.addPadrao(3, ComponenteTipo.CODIGO);
        conteudo.addPadrao(4, ComponenteTipo.DOUBLE);
        conteudo.addPadrao(5, ComponenteTipo.DOUBLE);
    }
}
