import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    private List<Product> productList;

    public ShoppingCart() {
        productList = new LinkedList<>();
    }

    public void adjustProdQtt(Product product, int newQuantity) {
        int oldQuantity = productList.stream().filter(product1 -> product1.equals(product)).collect(Collectors.toList()).size();
        if (oldQuantity < newQuantity) {
            for (int i = 0; i < newQuantity-oldQuantity; i++) {
                addProduct(product);
            }
        } else {
            for (int i = 0; i < oldQuantity-newQuantity; i++) {
                delProduct(product);
            }
        }
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    private void delProduct(Product product) {
        productList.remove(product);
    }

    public double getTotal() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getProductList() {
        this.productList = this.productList.stream().sorted().collect(Collectors.toList());
        return productList;
    }
}
