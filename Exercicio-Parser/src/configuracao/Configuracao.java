package configuracao;

import java.io.IOException;
import java.util.List;

public interface Configuracao {
    void lerConteudo(List<String> list) throws IOException;
    void imprimir();
}
