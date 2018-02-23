import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Store store = new Store();
    static ShoppingCart shoppingCart = new ShoppingCart();
    static ListClient listClient= new ListClient();
    static Printer printer = new Printer(System.out);

    public static void main(String[] args) {

        System.out.println("Welcome to e-commerce\n");




    }

    private static void sessionShowProducts() {
        printer.printProductList(store.getStore());
        int option = getValidOption(2, "You want to:\n1-Add product to cart\n2-Show your shopping cart");
        if (option == 1) {
            sessionAddProdToCart();
        } else {
            sessionShowShoppingCart();
        }
    }

    private static void sessionShowShoppingCart() {
        printer.printShoppingCart(shoppingCart.getProductList());
        int option = getValidOption(3, "You want to:\n1-Show product list\n2-Adjust item's quantity\n3-Checkout");
        if (option == 1) {
            sessionShowProducts();
        } else if (option == 2) {
            sessionAdjustItemQuantity();
        } else {

        }

    }

    private static void sessionAddProdToCart() {
        printer.print("Type the product name: ");
        String productName = scanner.nextLine();
        int quantity = getValidQuantity(productName);
        shoppingCart.addProduct(store.getProduct(productName));

    }

    private static void sessionAdjustItemQuantity() {
        printer.print("Type item to adjust: ");
        String productName = scanner.nextLine();
        Product product = store.getProduct(productName);
        printer.print("Type the new quantity: ");
        int newQuantity = getValidQuantity(productName);
        shoppingCart.adjustProdQtt(product, newQuantity);
        sessionShowShoppingCart();
    }

    private static void sessionCheckout() {
        printer.print("Type your id: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (listClient.hasClient(id)) {
            int option = getValidOption(2, "Choose a payment option:\n1-Bank Slip\n2-Credit Card");
            if (option == 2) {
                printer.print("Type your card number: ");
                int cardNumber = Integer.parseInt(scanner.nextLine());
                printer.print("Type times to pay (parcelas): ");
                int timesToPay = Integer.parseInt(scanner.nextLine());

            }

        }
    }


    private static int getValidOption(int maxOption, String msg) {
        printer.println(msg);
        int option = Integer.parseInt(scanner.nextLine());
        while (option < 1 || option > maxOption) {
            printer.println("Invalid option!");
            printer.println(msg);
            option = Integer.parseInt(scanner.nextLine());
        }
        return option;
    }

    private static int getValidQuantity(String productName) {
        printer.print("Type the quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        while (quantity < 1 || !store.hasProdEnough(productName, quantity)) {
            printer.println("Invalid quantity!");
            printer.print("Type the quantity: ");
            quantity = Integer.parseInt(scanner.nextLine());
        }
        return quantity;
    }
}
