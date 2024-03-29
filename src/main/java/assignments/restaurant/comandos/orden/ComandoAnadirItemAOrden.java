package assignments.restaurant.comandos.orden;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.menu.IMenu;
import assignments.restaurant.menu.MenuItem;
import assignments.restaurant.order.IOrder;
import assignments.restaurant.order.OrderItem;

import java.util.Scanner;

public class ComandoAnadirItemAOrden implements IComando {

    private IMenu menu;
    private IOrder order;

    public ComandoAnadirItemAOrden(IMenu menu, IOrder order) {
        this.menu = menu;
        this.order = order;
    }

    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Items disponibles en el menú:");
        for (MenuItem item : menu.getItems()) {
            System.out.println(item.getName() + " - " + item.getDescription());
        }

        System.out.println("Ingrese el nombre del ítem que desea añadir a la orden:");
        String itemName = scanner.nextLine();
        MenuItem selectedItem = menu.findItemByName(itemName);

        if (selectedItem != null) {
            System.out.println("Ingrese cualquier solicitud especial para este ítem: ");
            String specialRequest = scanner.nextLine();

            OrderItem orderItem = new OrderItem(selectedItem, specialRequest);
            order.addOrderItem(orderItem);

            System.out.println("Item añadido a la orden con éxito.");
        } else {
            System.out.println("Item no encontrado en el menú.");
        }

    }
}
