package assignments.paginador;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaginatedList list = new PaginatedList(); // Tamaño de página predeterminado
        PaginationController paginationController = new PaginationController(list);

        list.setPageSize(5);

        printMenu();

        while (true) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2); // Divide el input en 2 partes, el comando y el argumento
            String command = parts[0].toLowerCase(); // Para manejar mayúsculas y minúsculas indistintamente

            switch (command) {
                case "add":
                    if(parts.length > 1) {
                        list.addItem(parts[1]);
                    } else {
                        System.out.println("Please specify an item to add.");
                    }
                    break;
                case "first":
                    paginationController.firstPage();
                    break;
                case "last":
                    paginationController.lastPage();
                    break;
                case "next":
                    paginationController.nextPage();
                    break;
                case "prev":
                    paginationController.prevPage();
                    break;
                case "goto":
                    if (parts.length > 1 && isNumeric(parts[1])) {
                        int page = Integer.parseInt(parts[1]);
                        paginationController.showPage(page);
                    } else {
                        System.out.println("Please specify a valid page number.");
                    }
                    break;

                case "setsize":
                    if (parts.length > 1 && isNumeric(parts[1])) {
                        int size = Integer.parseInt(parts[1]);
                        list.setPageSize(size);
                    } else {
                        System.out.println("Please specify a valid page size.");
                    }
                    break;
                case "exit":
                    System.out.println("Exiting program.");
                    return;
                case "commands":
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    // Método auxiliar para verificar si un String es numérico
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Imprimir Menu
    private static void printMenu() {
        System.out.println("Welcome to the List Manager!");
        System.out.println("Commands:");
        System.out.println("  add <item> - Adds an item to the list.");
        System.out.println("  first - Displays the first page of the list.");
        System.out.println("  last - Displays the last page of the list.");
        System.out.println("  next - Displays the next page of the list.");
        System.out.println("  prev - Displays the previous page of the list.");
        System.out.println("  goto <page_number> - Goes to a specific page number.");
        System.out.println("  setsize <size> - Sets the number of items per page.");
        System.out.println("  commands - Print this menu again.");
        System.out.println("  exit - Exits the program.");
    }
}

