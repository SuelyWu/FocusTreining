package configuracao;

import componente.ComponenteTipo;

public class Configuracao2 extends Configuracao {

    public Configuracao2() {
        super();
        conteudo.addPadrao(1, ComponenteTipo.NOME);
        conteudo.addPadrao(2, ComponenteTipo.INTEIRO);
        conteudo.addPadrao(3, ComponenteTipo.CODIGO);
        conteudo.addPadrao(4, ComponenteTipo.DOUBLE);
        conteudo.addPadrao(5, ComponenteTipo.DOUBLE);
    }

}
