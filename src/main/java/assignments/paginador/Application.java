package assignments.paginador;

import assignments.paginador.comandos.EjecutorComandos;
import assignments.paginador.comandos.FabricaEjecutorComandos;

import java.util.Scanner;

public class Application {

    private static PaginatedList list = new PaginatedList();
    private static PaginationController paginationController = new PaginationController(list);
    private static EjecutorComandos ejecutor;

    public static void main(String[] args) {
        initialize();
        runCommandLoop();
    }

    private static void initialize() {
        list.setPageSize(5);
        ejecutor = FabricaEjecutorComandos.crearEjecutorConComandos(list, paginationController);
        printMenu();
    }

    private static void runCommandLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine().trim();
            processInput(input);
        }
    }

    private static void processInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        ejecutor.ejecutarComando(command, parts.length > 1 ? parts[1] : null);
    }

    private static void printMenu() {
        System.out.println("Commands:");
        System.out.println("  add <item> - Adds an item to the list.");
        System.out.println("  first - Displays the first page of the list.");
        System.out.println("  last - Displays the last page of the list.");
        System.out.println("  next - Displays the next page of the list.");
        System.out.println("  prev - Displays the previous page of the list.");
        System.out.println("  goto <page_number> - Goes to a specific page number.");
        System.out.println("  setsize <size> - Sets the number of items per page.");
        System.out.println("  exit - Exits the program.");
    }
}


