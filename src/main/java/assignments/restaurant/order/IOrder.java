package assignments.restaurant.order;

import java.util.List;

public interface IOrder {
    void addOrderItem(OrderItem orderItem);
    void removeOrderItem(OrderItem orderItem);
    void setTableNumber(int tableNumber);
    List<OrderItem> getOrderItems();
    int getTableNumber();
}
