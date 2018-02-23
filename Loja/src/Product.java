public class Product implements Comparable {

    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Product product) {
        return this.name.equalsIgnoreCase(product.name);
    }

    public boolean aquals(String productName) {
        return this.name.equalsIgnoreCase(productName);
    }

    @Override
    public int compareTo(Object o) {
        char char1 = name.toUpperCase().charAt(0);
        char char2 = ((Product)o).name.toUpperCase().charAt(0);
        if (char1 > char2) {
            return 1;
        }
        else if (char1 < char2) {
            return -1;
        } else {
            return 0;
        }
    }
}
