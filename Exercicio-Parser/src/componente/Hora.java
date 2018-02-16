package componente;

import java.time.LocalTime;

public class Hora {

    private LocalTime hora;

    public Hora (String stringHora) {
        String [] s = stringHora.split(":");
        int hora = Integer.parseInt(s[0]);
        int min = Integer.parseInt(s[1]);
        int seg = Integer.parseInt(s[2]);
        this.hora = LocalTime.of(hora, min, seg);
    }

    @Override
    public String toString() {
        String sHora, sMin, sSeg;
        if (hora.getHour() == 0) sHora = "00";
        else sHora = String.valueOf(hora.getHour());
        if (hora.getMinute() == 0) sMin = "00";
        else sMin = String.valueOf(hora.getMinute());
        if (hora.getSecond() == 0) sSeg = "00";
        else sSeg = String.valueOf(hora.getSecond());
        return sHora + ":" + sMin + ":" + sSeg;
    }
}
