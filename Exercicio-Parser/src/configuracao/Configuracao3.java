package configuracao;

import componente.ComponenteTipo;

public class Configuracao3 extends Configuracao {

    public Configuracao3() {
        super();
        conteudo.addPadrao(1, ComponenteTipo.DATA);
        conteudo.addPadrao(2, ComponenteTipo.HORA);
        conteudo.addPadrao(3, ComponenteTipo.NOME);
    }

}
