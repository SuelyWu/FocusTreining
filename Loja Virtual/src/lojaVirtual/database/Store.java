package lojaVirtual.database;

import lojaVirtual.product.Product;
import lojaVirtual.product.ProductHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Store {

    private List<ProductHolder> productHolderList;

    public Store(){
        productHolderList = new LinkedList<>();
        generateInitialProducts();
    }

    private void generateInitialProducts() {
        registerProduct("MESA001", "Mesa redonda", 30000, 20);
        registerProduct("MESA002", "Mesa retangular", 400, 20);
        registerProduct("ROUPA001", "Camiseta branca", 20, 20);
        registerProduct("ROUPA002", "Camiseta preta", 25, 20);
    }

    private void registerProduct(String serialNumber, String name, float price, int qtt) {
        Product product = new Product(serialNumber, name, price);
        ProductHolder holder = new ProductHolder(product, qtt);
        productHolderList.add(holder);
    }

    private int getProductQtt(Product product) {
        ProductHolder holder = getProductHolder(product);
        return holder.getQtt();
    }

    public void decreaseProduct(Product product, int qtt) {
        ProductHolder holder = getProductHolder(product);
        holder.decreaseQtt(qtt);
    }

    private ProductHolder getProductHolder(Product product) {
        Optional<ProductHolder> adjustableProductHolder = productHolderList.stream()
                .filter(productHolder -> productHolder.equals(product.getSerialNumber())).findFirst();
        return adjustableProductHolder.orElseThrow(() -> new RuntimeException()); // ProductNotFound  nao existe o produto pesquisado
    }

    public List getProducts() {
        return Collections.unmodifiableList(productHolderList);
    }

    public Product getProductByProductName(String productName) {
        Optional<ProductHolder> holderOpt = productHolderList.stream().filter(productHolder -> productHolder.getProduct().equals(productName)).findFirst();
        if (holderOpt.isPresent()) {
            return holderOpt.get().getProduct();
        } else {
            throw new RuntimeException("ProductNotFound"); // ProductNotFound
        }
    }

    public boolean hasProdEnough(Product product, int qttRequest) {
        return getProductQtt(product) >= qttRequest;
    }

    public boolean hasProduct(String productName) {
        return productHolderList.stream().anyMatch(productHolder -> productHolder.getProductName().equalsIgnoreCase(productName));
    }

}
