package usfx.assignments;

import usfx.assignments.comandos.FabricaEjecutorComandos;
import usfx.assignments.comandos.interfaces.IEjecutorComandos;
import usfx.assignments.menu.IMenu;
import usfx.assignments.menu.Menu;
import usfx.assignments.menu.MenuItem;
import usfx.assignments.order.IOrder;
import usfx.assignments.order.Order;
import usfx.assignments.order.OrderItem;
import usfx.assignments.table.Table;

import java.util.Scanner;

public class MainRestaurant {
    public static void main(String[] args) {

        MenuItem pizza = new MenuItem("Pizza", 45.00, "Pizza Margarita");
        MenuItem pasta = new MenuItem("Pasta", 35.00, "Spaghetti");
        MenuItem soda = new MenuItem("Soda", 7.00, "Coca-Cola");

        IMenu menu = new Menu();
        menu.addItem(pizza);
        menu.addItem(pasta);
        menu.addItem(soda);

        IOrder order = new Order();

        IEjecutorComandos ejecutorComandos = FabricaEjecutorComandos.crearEjecutorConComandos(menu, order);

        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Wellcome");
        do {
            printMenu();
            comando = scanner.nextLine();

            if (!comando.equals("exit")){
                ejecutorComandos.ejecutarComando(comando);
            }

        } while (!comando.equals("exit"));

        System.out.println("Exiting..");
    }

    private static void printMenu() {
        System.out.println("\nMenú de Comandos:");
        System.out.println("1. Add Item al Menú (addMenu)");
        System.out.println("2. Ver Menú (showMenu)");
        System.out.println("3. Actualizar Item del Menú (updateMenu)");
        System.out.println("4. Añadir Item a la Orden (addItem)");
        System.out.println("5. Ver Orden (showOrder)");
        System.out.println("6. Remover Item de la Orden (removeItem)");
        System.out.println("7. Salir (exit)");
        System.out.print("Seleccione una opción: ");
    }
}
