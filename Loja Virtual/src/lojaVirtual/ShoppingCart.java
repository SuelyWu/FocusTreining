package lojaVirtual;

import lojaVirtual.database.Store;
import lojaVirtual.product.Product;
import lojaVirtual.product.ProductHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {

    private List<ProductHolder> items = new LinkedList<>();

    private Optional<ProductHolder> getProductHolderOpt(Product product) {
        return items.stream().filter(productHolder -> productHolder.equals(product.getSerialNumber())).findFirst();
    }

    public void adjustItemQtt(Product product, int newQtt, Store store) {
        Optional<ProductHolder> holderOpt = getProductHolderOpt(product);
        if (holderOpt.isPresent()) {
            int oldQtt = holderOpt.get().getQtt();
            if (newQtt < oldQtt) {
                decreaseItem(product, newQtt);
            } else {
                increaseItem(product, newQtt, store);
            }
        }
    }

    public void increaseItem(Product product, int newQtt, Store store) {
        Optional<ProductHolder> holderOtp = getProductHolderOpt(product);
        if (store.hasProdEnough(product, newQtt)) {
            if (holderOtp.isPresent()) {
                ProductHolder holder = holderOtp.get();
                holder.increaseQtt(newQtt-holder.getQtt());
                return;
            }
            ProductHolder holder = new ProductHolder(product, newQtt);
            items.add(holder);
        }
    }

    private void decreaseItem(Product product, int newQtt) {
        Optional<ProductHolder> holderOpt = getProductHolderOpt(product);
        if (holderOpt.isPresent()) {
            ProductHolder holder = holderOpt.get();
            int oldQtt = holder.getQtt();
            if (newQtt == 0) {
                this.items.remove(holder);
            } else if (oldQtt-newQtt > 0) {
                holder.decreaseQtt(oldQtt-newQtt);
            } else {
                throw new IllegalArgumentException("Produto não deve ter valor negativo"); // qtt solicitado eh negativo
            }
        }
    }

    public List<ProductHolder> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getShoppingCartTotal() {
         return items.stream().mapToDouble(ProductHolder::getSubtotal).sum();
    }

    public List<ProductHolder> finishOrder() {
        List<ProductHolder> list = items;
        cleanCart();
        return list;
    }

    private void cleanCart() {
        this.items = new LinkedList<>();
    }
}
