import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private List<Product> store;

    public Store() {
        this.store = new ArrayList<>();
        generateInitialProducts();
    }

    public Product getProduct(String productName) {
        if (hasProduct(productName)) {
            return store.stream().filter(p -> p.equals(productName)).findAny().get();
        }
        return null;
    }

    public boolean hasProduct(String productName) {
        return !store.stream().filter(product -> product.getName().equalsIgnoreCase(productName)).collect(Collectors.toList()).isEmpty();
    }

    public boolean hasProdEnough(String productName, int quantity) {
        int quantityStock = 0;
        for (Product p : store) {
            if (p.equals(productName)) {
                quantityStock++;
            }
        }
        return quantity >= quantityStock;
    }

    public List<Product> getStore() {
        this.store = this.store.stream().sorted().collect(Collectors.toList());
        return Collections.unmodifiableList(store);
    }

    public void addProduct(Product product) {
        this.store.add(product);
    }

    public void delProduct(Product product) {
        this.store.remove(product);
    }

    private void generateInitialProducts() {
        for (int i = 0; i < 20; i++) {
            addProduct(new Product("Mesa redonda", 200));
            addProduct(new Product("Relógio pulso", 30));
            addProduct(new Product("Camiseta branca", 40));
        }
    }
}
