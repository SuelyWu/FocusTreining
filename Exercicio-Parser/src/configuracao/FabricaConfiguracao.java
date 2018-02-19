package configuracao;

public class FabricaConfiguracao {

    public Configuracao getConfiguracao(int intConfigRecebido) throws RuntimeException {
        switch (intConfigRecebido) {
            case 1: return new Configuracao1();
            case 2: return new Configuracao2();
            case 3: return new Configuracao3();
            default: throw new ProcessingException();
        }
    }

}
