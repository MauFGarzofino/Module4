package assignments.restaurant.comandos.menu;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.menu.IMenu;
import assignments.restaurant.menu.MenuItem;

import java.util.Scanner;

public class ComandoAdicionarItemsAlMenu implements IComando {

    private IMenu menu;

    public ComandoAdicionarItemsAlMenu(IMenu menu) {
        this.menu = menu;
    }

    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del ítem:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el precio del ítem:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consume la línea nueva

        System.out.println("Ingrese la descripción del ítem:");
        String descripcion = scanner.nextLine();

        MenuItem item = new MenuItem(nombre, precio, descripcion);
        menu.addItem(item);
        System.out.println("Item añadido al menú: " + item.getName());
    }
}
