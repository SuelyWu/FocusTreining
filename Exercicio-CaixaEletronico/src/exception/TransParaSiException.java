package exception;

public class TransParaSiException extends CaixaException {

    private String msg;

    public TransParaSiException() {
        this.msg = "Transferência para própria conta!";
    }

    public TransParaSiException (String msg) {
        super(msg);
        this.msg = msg;
    }

    public TransParaSiException (String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }


}
