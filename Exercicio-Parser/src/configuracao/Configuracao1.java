package configuracao;

import componente.*;
import java.util.*;

public class Configuracao1 extends Configuracao {

    private Conteudo conteudo;
    // definir como compoe uma conteudo (as colunas, componentes de uma conteudo)
    // int double data codigo int
    //Map<Integer, List> conteudo;
    // Map<Integer, Map<ComponenteTipo, List<Componente>> conteudo

    public Configuracao1() {
        conteudo = new Conteudo();
        conteudo.addPadrao(1, ComponenteTipo.INTEIRO);
        conteudo.addPadrao(2, ComponenteTipo.DOUBLE);
        conteudo.addPadrao(3, ComponenteTipo.DATA);
        conteudo.addPadrao(4, ComponenteTipo.CODIGO);
        conteudo.addPadrao(5, ComponenteTipo.INTEIRO);
    }
}
