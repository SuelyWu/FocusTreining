import componente.Conteudo;
import componente.Data;
import componente.Hora;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Class, List> map = new HashMap<>();

    public static void main(String[] args) {



        map.put(Data.class, null);
        addPadrao(Data.class);





    }

    public static void addPadrao(Class c) {
        map.put(c, null);
    }


}


// cada modelo tem seu tipo de compor linha
// um list de linhas