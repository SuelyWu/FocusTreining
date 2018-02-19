package exception;

public class ConfigInexistenteException extends ParserException {

    private String msg;

    public ConfigInexistenteException () {
        this.msg = "Configuração inexistente!";
    }

    public ConfigInexistenteException (String msg) {
        super(msg);
        this.msg = msg;
    }

    public ConfigInexistenteException (String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

}
