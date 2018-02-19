package configuracao;

import componente.*;
import java.util.*;

public class Configuracao1 extends Configuracao {

    public Configuracao1() {
        super();
        conteudo.addPadrao(1, ComponenteTipo.INTEIRO);
        conteudo.addPadrao(2, ComponenteTipo.DOUBLE);
        conteudo.addPadrao(3, ComponenteTipo.DATA);
        conteudo.addPadrao(4, ComponenteTipo.CODIGO);
        conteudo.addPadrao(5, ComponenteTipo.INTEIRO);
    }
}
