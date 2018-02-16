package componente;

public class Double implements Componente {

    private double valorDouble;
    private int casasDecimais;

    public Double (String stringDouble) {
        valorDouble = java.lang.Double.parseDouble(stringDouble);
        this.casasDecimais = stringDouble.split("\\.")[1].length();
    }

    @Override
    public String toString() {
        return String.format("%." + casasDecimais + "f", valorDouble);
    }
}
