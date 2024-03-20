package assignments.restaurant;

import assignments.restaurant.comandos.FabricaEjecutorComandos;
import assignments.restaurant.menu.IMenu;
import assignments.restaurant.menu.Menu;
import assignments.restaurant.menu.MenuItem;
import assignments.restaurant.order.IOrder;
import assignments.restaurant.order.Order;
import assignments.restaurant.comandos.interfaces.IEjecutorComandos;

import java.util.Scanner;

public class MainRestaurant {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        IMenu menu = createMenu();
        IOrder order = new Order();
        IEjecutorComandos ejecutorComandos = FabricaEjecutorComandos.crearEjecutorConComandos(menu, order);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Restaurant Management System!");

        String comando;
        while (true) {
            printCommandMenu();
            comando = getUserInput(scanner);
            processCommand(comando, ejecutorComandos);
        }
    }

    private static String getUserInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void processCommand(String comando, IEjecutorComandos ejecutorComandos) {
        if (!comando.equalsIgnoreCase("exit")) {
            ejecutorComandos.ejecutarComando(comando);
        }
    }

    private static IMenu createMenu() {
        MenuItem pizza = new MenuItem("Pizza", 45.00, "Pizza Margarita");
        MenuItem pasta = new MenuItem("Pasta", 35.00, "Spaghetti");
        MenuItem soda = new MenuItem("Soda", 7.00, "Coca-Cola");

        IMenu menu = new Menu();
        menu.addItem(pizza);
        menu.addItem(pasta);
        menu.addItem(soda);
        return menu;
    }

    private static void printCommandMenu() {
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
