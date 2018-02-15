package exception;

public class NotaInexistenteException extends CaixaException {

    private String msg;

    public NotaInexistenteException () {
        this.msg = "Nota inexistente para este valor!";
    }

    public NotaInexistenteException (String msg) {
        super(msg);
        this.msg = msg;
    }

    public NotaInexistenteException (String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

}
