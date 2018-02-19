package configuracao;

import exception.ConfigInexistenteException;
import exception.ParserException;

public class FabricaConfiguracao {

    public FabricaConfiguracao() {

    }

    public Configuracao getConfiguracao(int intConfigRecebido) throws ParserException {
        switch (intConfigRecebido) {
            case 1: return new Configuracao1();
            case 2: return new Configuracao2();
            default: throw new ConfigInexistenteException();
        }
    }

}
