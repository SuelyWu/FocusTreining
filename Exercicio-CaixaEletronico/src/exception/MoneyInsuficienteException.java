package exception;

public class MoneyInsuficienteException extends CaixaException {

    private String msg;

    public MoneyInsuficienteException () {
        this.msg = "Desculpa, nota insuficiente!";
    }

    public MoneyInsuficienteException (String msg) {
        super(msg);
        this.msg = msg;
    }

    public MoneyInsuficienteException (String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
