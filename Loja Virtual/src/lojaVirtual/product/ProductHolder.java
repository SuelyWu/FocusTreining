package lojaVirtual.product;

public class ProductHolder {

    private final Product product;
    private int qtt;

    public ProductHolder(final Product product, int qtt) {
        this.product = product;
        this.qtt = qtt;
    }

    public int getQtt() {
        return this.qtt;
    }

    public void decreaseQtt(int qtt) {
        this.qtt = getQtt()-qtt;
    }

    public void increaseQtt(int qtt) {
        this.qtt = getQtt()+qtt;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return product.getName();
    }

    public float getProductPrice() {
        return product.getPrice();
    }

    public double getSubtotal() {
        return product.getPrice() * qtt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return this.product.getSerialNumber().equalsIgnoreCase((String)obj);
        }
        return super.equals(obj);
    }




}