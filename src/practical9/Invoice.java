package practical9;

import java.util.List;

public class Invoice {
    private List<Item> items;
    private Customer customer;

    public void generateInvoice() {
        if (customer == null) {
            System.out.println("Customer is null");
            return;
        }

        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }

        if (total > 1000) {
            total *= 0.9;
        }

        System.out.println("Total: " + total);
    }
}
