package exception;

public class CaixaException extends Exception {

    public CaixaException() {

    }

    public CaixaException (String msg) {
        super(msg);
    }

    public CaixaException (String msg, Throwable cause) {
        super(msg, cause);
    }

}
