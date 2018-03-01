package lojaVirtual;

import lojaVirtual.database.ListClients;
import lojaVirtual.database.Store;
import lojaVirtual.payment.PaymentOption;
import lojaVirtual.printer.Printer;
import lojaVirtual.product.Product;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class ShopFacade {

    private Scanner scanner;
    private Printer printer;
    private ListClients listClients;
    private Store store;
    private ShoppingCart shoppingCart;

    public ShopFacade(InputStream in, OutputStream out) {
        scanner = new Scanner(in);
        printer = new Printer(out);
        listClients = new ListClients();
        store = new Store();
        shoppingCart = new ShoppingCart();
    }

    public void startShop() {
        printer.println("Bem vindo a Loja Virtual");
        sessionShowProducts();
    }


    private void sessionShowProducts() {
        printer.printProducts(store.getProducts());
        int option = getValidOption(2, "Você quer:\n1-Adicionar item\n2-Ver carrinho de compras");
        if (option==1) {
            sessionAddItem();
        } else {
            sessionShowShoppingCart();
        }
    }

    private void sessionShowShoppingCart() {
        printer.printShoppingCart(shoppingCart.getItems());
        int option = getValidOption(3, "Você quer:\n1-Ver lista produto\n2-Ajustar quantidade de um item\n3-Finalizar compra");
        switch (option) {
            case 1: sessionShowProducts();
            case 2: sessionAdjustQttItem();
            case 3: sessionFinishOrder();
        }
    }

    private void sessionAddItem() {
        Product product = getValidProduct();
        int qtt = getValidaQuantity(product);
        shoppingCart.increaseItem(product, qtt, store);
        sessionShowShoppingCart();
    }

    private void sessionAdjustQttItem() {
        Product product = getValidProduct();
        int qtdNova = getValidaQuantity(product);
        shoppingCart.adjustItemQtt(product, qtdNova, store);
        sessionShowShoppingCart();
    }

    private void sessionFinishOrder() {
        Client client = getValidClient();
        PaymentOption paymentOption = choosePaymentOption();
        OrderFinisherContext context = new OrderFinisherContext(paymentOption, shoppingCart.getShoppingCartTotal(), client);
        if (paymentOption.equals(PaymentOption.CREDIT_CARD)) {
            setContextToCreditCard(context);
        }
        OrderFinisher orderFinisher = new OrderFinisher(shoppingCart, store);
        Order order = orderFinisher.finishOrder(context);
        printer.printBuyReceipt(order);
        sessionShowShoppingCart();
        sessionShowProducts();
    }


    private Product getValidProduct() {
        printer.print("Digite o nome do produto: ");
        String productName = scanner.nextLine();
        while (!store.hasProduct(productName)) {
            printer.print("Erro! Digite o nome do produto novamente: ");
            productName = scanner.nextLine();
        }
        return store.getProductByProductName(productName);
    }

    private int getValidaQuantity(Product product) {
        printer.print("Digite a quantidade: ");
        int qtt = Integer.parseInt(scanner.nextLine());
        while (qtt < 0 || !store.hasProdEnough(product, qtt)) {
            printer.print("Erro! Digite a quantidade novamente: ");
            qtt = Integer.parseInt(scanner.nextLine());
        }
        return qtt;
    }

    private Client getValidClient() {
        printer.print("Digite seu id: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (!listClients.hasClient(id)) {
            printer.print("Erro! Digite seu id novamente: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        return listClients.getClientById(id);
    }

    private int getValidOption(int maxOption, String msg) {
        printer.println(msg);
        int option = Integer.parseInt(scanner.nextLine());
        while (option < 1 || option > maxOption) {
            printer.println("Opção inválida!");
            printer.println(msg);
                option = Integer.parseInt(scanner.nextLine());
        }
        return option;
    }

    private PaymentOption choosePaymentOption() {
        int option = getValidOption(2, "Escolha um tipo de pagamento:\n1-Boleto\n2-Cartão");
        if (option==1) return PaymentOption.BILLET;
        if (option==2) return PaymentOption.CREDIT_CARD;
        return null;
    }

    private void setContextToCreditCard(OrderFinisherContext context) {
        printer.print("Digite o número do cartão: ");
        String cardNumber = scanner.nextLine();
        printer.print("Digite a quantidade de parcelas: ");
        int timesToPay = Integer.parseInt(scanner.nextLine());
        context.setCardNumber(new BigInteger(cardNumber));
        context.setTimesToPay(timesToPay);
    }


}