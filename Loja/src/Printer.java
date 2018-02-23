import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {

    private PrintStream out;

    public Printer(OutputStream outputStream) {
        this.out = new PrintStream(outputStream);
    }

    public void printProductList(List productList) {
        out.println("=============================================================");
        out.println("We have:");
        out.println("\tProdct\t\t\t\t\tPrice\t\t\tQuantity");
        List usedProduct = new ArrayList();
        for (Object product : productList) {
            if (usedProduct.contains(((Product)product).getName())) {
                continue;
            }
            List newList = (List) productList.stream().filter(o -> ((Product)o).equals((Product)product)).collect(Collectors.toList());
            out.println(String.format("\t%s\t\t\tR$ %.2f\t\t%d",
                    ((Product)product).getName(), ((Product) product).getPrice(), newList.size()));
            usedProduct.add(((Product)product).getName());
        }
        out.println();
    }

    public void printShoppingCart(List productList) {
        out.println("=============================================================");
        if (productList.isEmpty()) {
            out.println("Your shopping cart is empty!");
            return;
        }
        out.println("Your shopping cart:");
        out.println("\tItem\t\t\t\t\tPrice\t\t\tQuantity\t\tSubtotal");
        List usedProduct = new ArrayList();
        double total = 0;
        for (Object product : productList) {
            if (usedProduct.contains(((Product)product).getName())) {
                continue;
            }
            List newList = (List) productList.stream().filter(o -> ((Product)o).equals((Product)product)).collect(Collectors.toList());
            out.println(String.format("\t%s\t\t\tR$ %.2f\t\t%d\t\t\t\tR$ %.2f",
                    ((Product)product).getName(), ((Product) product).getPrice(), newList.size(), newList.size()*((Product) product).getPrice()));
            usedProduct.add(((Product)product).getName());
            total += ((Product) product).getPrice() * newList.size();
        }
        out.println(String.format("\t\t\t\t\t\t\t\t\t\t\tTotal:\t\t\tR$ %.2f\n", total));
    }

    public void printBarCode(List listBarCode) {
        listBarCode.stream().forEach(o -> out.print(o + " "));
    }

    public void print(Object obj) {
        out.print(obj);
    }

    public void println(Object obj) {
        out.println(obj);
    }

}
