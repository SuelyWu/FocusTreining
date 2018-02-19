package componente;

public class FabricaComponente {

    Componente getComponente(ComponenteTipo componenteTipo, String stringComponente) {
        switch (componenteTipo) {
            case DATA: return new Data(stringComponente);
            case HORA: return new Hora(stringComponente);
            case NOME: return new Nome(stringComponente);
            case CODIGO: return new Codigo(stringComponente);
            case DOUBLE: return new Double(stringComponente);
            case INTEIRO: return new Inteiro(stringComponente);
            default: return null;
        }
    }



}
