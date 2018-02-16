package componente;

import java.time.LocalDate;

public class Data implements Componente{

    private LocalDate data;

    public Data (String stringData) {
        String[] s = stringData.split("/");
        int dia, mes, ano;
        if (Integer.parseInt(s[0]) > 1000) { // se primeiro campo for ano
            ano = Integer.parseInt(s[0]);
            dia = Integer.parseInt(s[2]);
        } else {
            dia = Integer.parseInt(s[0]);
            ano = Integer.parseInt(s[2]);
        }
        mes = Integer.parseInt(s[1]);
        this.data = LocalDate.of(ano, mes, dia);
    }




    @Override
    public String toString() {
        String sDia = "", sMes = "", sAno = "";

        if (data.getDayOfMonth() < 10) sDia += "0";
        sDia += String.valueOf(data.getDayOfMonth());
        if (data.getMonthValue() < 10) sMes += "0";
        sMes += String.valueOf(data.getMonthValue());
        sAno += String .valueOf(data.getYear());


        return sDia + "/" + sMes + "/" + sAno;
    }

}
