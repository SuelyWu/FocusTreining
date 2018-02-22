import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Printer {

    private PrintStream out;

    public Printer(OutputStream outputStream) {
        out = new PrintStream(outputStream);
    }

    public void print(Object obj) {
        out.print(obj);
    }

    public void println(Object obj) {
        out.println(obj);
    }

    public void printProdutos(Map mapArmazem) {
        out.println();
        out.println("=====================================================================================");
        out.println("PRODUTOS");
        out.println("\tProduto\t\t\t\tPreço Unitário\t\tEstoque");
        List listTipoExistente = Arrays.asList(mapArmazem.keySet().toArray());
        listTipoExistente = (List) listTipoExistente.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < listTipoExistente.size(); i++) {
            ProdutoTipo produtoTipo = (ProdutoTipo) listTipoExistente.get(i);
            List listProd = (List) mapArmazem.get(produtoTipo);
            Produto produto = (Produto)listProd.get(i);
            out.println(String.format("\t%s\t\tR$ %.2f\t\t\t%d", produto.getNome(), produto.getPreco(), listProd.size()));
        }
        out.println();
    }

    public void printCarrinho(List listItens) {
        out.println();
        out.println("=====================================================================================");
        out.println("Carrinho de Compras:");

        if (listItens.isEmpty()){
            out.println("Seu carrinho está vazio!");
            return;
        }

        out.println("\tProduto\t\t\t\tPreço Unitário\t\tQuantidade\t\tSubtotal");
        double total = 0;
        for (int i = 0; i < listItens.size(); i++){
            ItemPedido itemPedido = (ItemPedido) listItens.get(i);
            total += itemPedido.getSubtotal();
            out.println(String.format("\t%s\t\tR$ %.2f\t\t\t%d\t\t\t\tR$ %.2f",
                    itemPedido.getProdNome(), itemPedido.getProdPreco(), itemPedido.getQtd(), itemPedido.getSubtotal()));
        }
        out.println(String.format("\t\t\t\t\t\t\t\t\t\t\tTotal:\t\t\tR$ %.2f", total));
        out.println();
    }

    public void printBoletoCodBarras(List listCodBarras) {
        out.println("Código de barras:");
        for (int i = 0; i < listCodBarras.size(); i++) {
            String parteAtual = String.valueOf(listCodBarras.get(i));
            out.print(parteAtual + " ");
        }
        out.println();
    }

}
