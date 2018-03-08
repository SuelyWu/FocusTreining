package lojaVirtual.printer;

import lojaVirtual.Order;
import lojaVirtual.payment.Payment;
import lojaVirtual.payment.PaymentBillet;
import lojaVirtual.payment.PaymentCreditCard;
import lojaVirtual.product.ProductHolder;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Printer {

    private PrintStream out;

    public Printer(OutputStream outputStream) {
        out = new PrintStream(outputStream);
    }

    public void print(String str) {
        out.print(str);
    }

    public void println(String str) {
        out.println(str);
    }

    public void printProducts(List<ProductHolder> storeList) {
        out.println();
        out.println("=====================================================================================");
        out.println("PRODUTOS");
        out.println("\tProduto\t\t\t\tPreço Unitário\t\tEstoque");
        storeList.forEach(o -> out.println(String.format("\t%s\t\tR$ %,10.2f\t\t%5d",
                        o.getProductName(),
                        o.getProductPrice(),
                        o.getQtt())));
        out.println();
    }

    public void printShoppingCart(List listItems) {
        out.println();
        out.println("=====================================================================================");
        out.println("Carrinho de Compras:");

        if (listItems.isEmpty()){
            out.println("\tSeu carrinho está vazio!\n");
            return;
        }

        out.println("\tProduto\t\t\t\tPreço Unitário\t\tQuantidade\t\tSubtotal");
        double total = 0;
        listItems.forEach(o -> out.println(String.format("\t%s\t\tR$ %,10.2f\t\t%5d\t\t\tR$ %,10.2f",
                ((ProductHolder)o).getProductName(),
                ((ProductHolder)o).getProductPrice(),
                ((ProductHolder)o).getQtt(),
                ((ProductHolder)o).getSubtotal())));
        for (Object o : listItems) {
            total += ((ProductHolder)o).getSubtotal();
        }
        out.println(String.format("\t\t\t\t\t\t\t\t\t\t\tTotal:\t\t\tR$ %,10.2f", total));
        out.println();
    }

    public void printBuyReceipt(Order order) {
        Payment payment = order.getPayment();
        out.println();
        out.println("*************************************************************************************");
        out.println("Cliente: " + order.getClientName());
        out.println("Data da compra: " + order.getPurchaseDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss")));
        out.println();
        out.print("Opção de pagamento: " + payment.getPaymentOption());
        printPaymentDetails(payment);
        List listItems = order.getPurchasedItems();
        out.println("\nItems comprados:");
        out.println("\tProduto\t\t\t\tPreço Unitário\t\tQuantidade\t\tSubtotal");
        double total = 0;
        listItems.forEach(o -> out.println(String.format("\t%s\t\tR$ %,10.2f\t\t%5d\t\t\t\tR$ %,10.2f",
                ((ProductHolder)o).getProductName(),
                ((ProductHolder)o).getProductPrice(),
                ((ProductHolder)o).getQtt(),
                ((ProductHolder)o).getSubtotal())));
        for (Object o : listItems) {
            total += ((ProductHolder)o).getSubtotal();
        }
        out.println(String.format("\t\t\t\t\t\t\t\t\t\t\tTotal:\t\t\tR$ %,10.2f", total));
        out.println("*************************************************************************************");

    }

    private void printPaymentDetails(Payment payment) {
        switch (payment.getPaymentOption()) {
            case CREDIT_CARD:   printCreditCard((PaymentCreditCard)payment); break;
            case BILLET:        printBillet((PaymentBillet)payment);
        }
    }

    private void printCreditCard(PaymentCreditCard payment) {
        out.println();
        out.println("Número de cartão: " + payment.getCardNumber());
        out.println("Quantidade parcelas: " + payment.getTimesToPay());
        out.println(String.format("Valor parcela: R$ %,10.2f", payment.getValorParcela()));
    }

    private void printBillet(PaymentBillet payment) {
        out.println();
        List listBarCode = payment.getBarCode();
        out.println(String.format("\nValor do Boleto: R$ %,10.2f", payment.getValorParcela()));
        out.println("Código de barras: ");
        for (int i = 0; i < listBarCode.size(); i++) {
            String actualPart = String.valueOf(listBarCode.get(i));
            out.print(actualPart + " ");
        }
        out.println();
    }

}
