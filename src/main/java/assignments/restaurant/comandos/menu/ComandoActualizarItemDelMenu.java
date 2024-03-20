package assignments.restaurant.comandos.menu;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.menu.IMenu;
import assignments.restaurant.menu.MenuItem;

import java.util.Scanner;
public class ComandoActualizarItemDelMenu implements IComando {
    private IMenu menu;
    private Scanner scanner;

    public ComandoActualizarItemDelMenu(IMenu menu) {
        this.menu = menu;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void ejecutar() {


        System.out.println("Ingrese el nombre del item a actualizar");
        String nombre = scanner.nextLine();

        MenuItem item = menu.findItemByName(nombre);
        if(item != null) {
            System.out.println("Item: " + item.getName() + " Precio antiguo: " + item.getPrice());
            System.out.println("Ingrese el nuevo precio:");
            while (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.println("Por favor, ingrese un número válido para el precio:");
            }
            double precio = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingrese la nueva descripción del item:");
            String description = scanner.nextLine();

//            item.setPrice(precio);
//            item.setDescription(description);
            menu.updateItem(nombre, precio, description);
            System.out.println("Item actualizado: " + item.getName() + " Nuevo precio: " + item.getPrice() + " Nueva descripción: " + item.getDescription());
        } else {
            System.out.println("Item no encontrado en el menú");
        }
    }
}
