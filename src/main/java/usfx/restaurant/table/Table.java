package usfx.restaurant.table;

import usfx.restaurant.order.Order;

public class Table {
    private int number;
    private boolean isOccupied;
    private Order currentOrder;

    // enum para los estados de mesa
    public enum TableStatus {
        FREE, OCCUPIED, RESERVER, WAITING_FOR_ORDER, SERVED
    }

    private TableStatus status; // Usando el enum para el estado de la mesa

    public Table(int number) {
        this.number = number;
        this.isOccupied = false;
        this.currentOrder = null;
        status = TableStatus.FREE; // Estado inicial de la mesa
    }

    // Methods
    public void assignOrderToTable(Order order) {
        if (status == TableStatus.FREE) {
            setCurrentOrder(order);
            setOccupied(true);
            status = TableStatus.OCCUPIED; // Actualizamos el estado de la mesa
        } else {
            System.out.println("The table is occupied");
        }
    }

    // Incializador
    public void clearTable() {
        setOccupied(false);
        setCurrentOrder(null);
        status = TableStatus.FREE;
    }

    @Override
    public String toString() {
        return "Table (" +
                "number =" + number + ", status = " + status +
                ", currentOrder = " + (currentOrder != null ? currentOrder.toString() : "No Order") +
                ')';
    }

    // Getters / Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
