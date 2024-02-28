package usfx.assignments.invoice;

import usfx.assignments.order.Order;

public class Invoice {
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public double calculateTotal() {
        //Calculate el total de la order
        return 0.0;
    }

}
