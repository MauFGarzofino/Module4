package usfx.assignments.comandos.menu;

import usfx.assignments.comandos.interfaces.IComando;
import usfx.assignments.menu.IMenu;
import usfx.assignments.menu.Menu;
import usfx.assignments.menu.MenuItem;

import java.util.Scanner;

public class ComandoActualizarItemDelMenu implements IComando {

    private IMenu menu;

    public ComandoActualizarItemDelMenu(IMenu menu) {
        this.menu = menu;
    }
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del item a actualizar");
        String nombre = scanner.nextLine();

        MenuItem item = menu.findItemByName(nombre);
        if(item != null) {
            System.out.println("Ingrese el nuevo precio");
            Double precio = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingrese la nueva descripción del item; ");
            String description = scanner.nextLine();

            item.setPrice(precio);
            item.setDescription(description);
            System.out.println("Item actualizado: " + item.getName() + " Nuevo precio: " + item.getPrice() + " Nueva descripción: " + item.getDescription());
        } else {
            System.out.println("Item no encontrado en el menú");
        }
    }
}
