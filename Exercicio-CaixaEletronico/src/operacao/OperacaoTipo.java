package operacao;

public enum OperacaoTipo {

    SALDO, SAQUE, DEPOSITO, TRANSFERENCIA, EXTRATO;

    @Override
    public String toString() {
        switch (this) {
            case SALDO:         return "saldo";
            case SAQUE:         return "saque";
            case EXTRATO:       return "extrato";
            case DEPOSITO:      return "depósito";
            case TRANSFERENCIA: return "transferência";
                default:        return "não identificado";
        }
    }



}
