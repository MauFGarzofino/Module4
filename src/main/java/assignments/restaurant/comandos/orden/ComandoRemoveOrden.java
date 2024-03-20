package assignments.restaurant.comandos.orden;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.order.IOrder;
import assignments.restaurant.order.OrderItem;

import java.util.List;
import java.util.Scanner;

public class ComandoRemoveOrden implements IComando {
    private IOrder order;
    private Scanner scanner;

    public ComandoRemoveOrden(IOrder order) {
        this.order = order;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void ejecutar() {
        List<OrderItem> items = order.getOrderItems();
        if (items.isEmpty()) {
            System.out.println("La orden no tiene items");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ": " + items.get(i).getItem().getName());
        }

        System.out.println("Seleccione el número del item que quiere remover: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < items.size()) {
            order.removeOrderItem(items.get(index));
            System.out.println("Item removido");
        } else {
            System.out.println("Selección inválida");
        }
    }
}
