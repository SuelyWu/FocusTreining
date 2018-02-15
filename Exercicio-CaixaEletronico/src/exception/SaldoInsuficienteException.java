package exception;

public class SaldoInsuficienteException extends CaixaException{

    private String msg;

    public SaldoInsuficienteException() {
        this.msg = "Saldo insuficiente!";
    }

    public SaldoInsuficienteException (String msg) {
        super(msg);
        this.msg = msg;
    }

    public SaldoInsuficienteException (String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

}
