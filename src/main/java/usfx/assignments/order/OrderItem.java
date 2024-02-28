package usfx.assignments.order;

import usfx.assignments.menu.MenuItem;

public class OrderItem {
    private MenuItem item;
    private String specialRequest;

    public OrderItem(MenuItem item, String specialRequest) {
        // Para evitar que item sea null
//        if (item != null) {
//            this.item = item;
//        } else {
//            throw new IllegalArgumentException("Item cannot be null");
//        }
        this.item = item;
        this.specialRequest = specialRequest;
    }

    // getters / setters
    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}
