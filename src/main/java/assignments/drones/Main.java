package assignments.drones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer y crear drones y localizaciones
        List<Drone> drones = readDrones(scanner);
        List<Location> locations = readLocations(scanner);

        // Creamos el DeliveryPlanner
        IDeliveryStrategy strategy = new EfficientDeliveryStrategy();
        DeliveryPlanner planner = new DeliveryPlanner(strategy);

        // Planificar y asignar las entregas
        planner.planDeliveries(drones, locations);
    }

    private static List<Drone> readDrones(Scanner scanner) {
        List<Drone> drones = new ArrayList<>();
        System.out.println("Enter number of drones:");
        int numberOfDrones = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfDrones; i++) {
            System.out.println("Enter drone name:");
            String name = scanner.nextLine();

            System.out.println("Enter drone max weight:");
            int maxWeight = Integer.parseInt(scanner.nextLine());

            drones.add(new Drone(name, maxWeight));
        }
        return drones;
    }

    private static List<Location> readLocations(Scanner scanner) {
        List<Location> locations = new ArrayList<>();
        System.out.println("Enter number of locations:");
        int numberOfLocations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLocations; i++) {
            System.out.println("Enter location name:");
            String name = scanner.nextLine();

            System.out.println("Enter package weight:");
            int packageWeight = Integer.parseInt(scanner.nextLine());

            locations.add(new Location(name, packageWeight));
        }
        return locations;
    }

}

