package exception;

public class ContaInvalidaException extends CaixaException {
    private String msg;

    public ContaInvalidaException () {
        this.msg = "Conta inválida!";
    }

    public ContaInvalidaException (String msg) {
        super(msg);
        this.msg = msg;
    }

    public ContaInvalidaException (String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
