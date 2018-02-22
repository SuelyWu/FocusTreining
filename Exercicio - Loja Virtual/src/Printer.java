import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Printer {

    // tomar como exemplo subwayprinter de headfirst

    private PrintStream out;

    public Printer(OutputStream outputStream) {
        out = new PrintStream(outputStream);
    }

    public void printProdutos(Map mapArmazem) {

        List listCategExist = Arrays.asList(mapArmazem.keySet().toArray());
        for (int i = 0; i < listCategExist.size(); i++) {
            Categoria categoria = (Categoria) listCategExist.get(i);
            out.println(categoria);
            Map mapProdEmCategoria = (Map) mapArmazem.get(categoria);
            List listCod = Arrays.asList(mapProdEmCategoria.keySet().toArray());
            for (int j = 0; j < listCod.size(); j++) {
                int codAtual = (int) listCod.get(j);
                List listProdMsmCod = (List) mapProdEmCategoria.get(codAtual);
                Produto produto = (Produto) listProdMsmCod.get(0);
                out.println(String.format("\t%s\tR$ %.2f\t%d", produto.getNome(), produto.getPreco(), listProdMsmCod.size()));
            }
        }

    }
    /*
    Produto         Preço Unitário      Quantidade      Subtotal
    mesa redonda    R$ 300.00           2               R$ 600.00

    0   1   2   3   4   5   6   7   8   9Total: R$ 600.00
     */

    public void printCarrinho(List listItens) {
        out.println("Carrinho de Compras:");
        out.println("\tProduto\t\t\tPreço Unitário\t\tQuantidade\t\tSubtotal");
        double total = 0;
        for (int i = 0; i < listItens.size(); i++){
            ItemCompra itemCompra = (ItemCompra) listItens.get(i);
            total += itemCompra.getSubtotal();
            out.println(String.format("\t%s\tR$ %.2f\t\t\t%d\t\t\t\tR$ .2f",
                    itemCompra.getProdNome(), itemCompra.getProdPreco(), itemCompra.getQtd(), itemCompra.getSubtotal()));
        }
        out.println(String.format("\t\t\t\t\t\t\t\t\tTotal: R$ .2f", total));
    }

    public void printBoletoCodBarras(List listCodBarras) {
        out.println("Código de barras:");
        for (int i = 0; i < listCodBarras.size(); i++) {
            String parteAtual = String.valueOf(listCodBarras.get(i));
            out.print(parteAtual + " ");
        }
        System.out.println();
        /*
    Codigo de barras eh composto por 5 partes
    00000.00000 00000.00000 00000.00000 0 00000000000000
    parte1      parte2      parte3      4   parte5
    List        List        List
     */
    }

}
