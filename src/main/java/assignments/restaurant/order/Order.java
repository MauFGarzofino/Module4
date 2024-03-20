package assignments.restaurant.order;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder{
    private List<OrderItem> orderItems;
    private int tableNumber;

    public Order() {
        this.tableNumber = 0;
        this.orderItems = new ArrayList<>();
    }

    // Methods
    @Override
    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    @Override
    public void removeOrderItem(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
    }

    @Override
    public void setTableNumber(int tableNumber) {
        if (tableNumber > 0) {
            this.tableNumber = tableNumber;
        } else {
            System.out.println("Invalid table number");
        }
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order for Table: " + tableNumber + "\n");
        for (OrderItem item : orderItems) {
            sb.append(item.getItem().getName()).append(" - ").append(item.getItem().getPrice()).append(" - ").append(item.getSpecialRequest()).append("\n");
        }
        return sb.toString();
    }
}
