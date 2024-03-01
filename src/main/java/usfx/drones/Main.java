package usfx.drones;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DroneSquad squad = new DroneSquad();

        System.out.println("Enter the number of drones:");
        int numberOfDrones = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfDrones; i++) {
            System.out.println("Enter drone " + (i + 1) + " name:");
            String droneName = scanner.nextLine();

            System.out.println("Enter " + droneName + "'s capacity:");
            int capacity = scanner.nextInt();
            scanner.nextLine();

            Drone drone = new Drone(droneName, capacity);
            squad.addDrone(drone);
        }

        Locations locations = new Locations();

        System.out.println("Enter the number of locations:");
        int numberOfLocations = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfLocations; i++) {
            System.out.println("Enter location " + (i + 1) + " name:");
            String locationName = scanner.nextLine();

            System.out.println("Enter the package weight for " + locationName + ":");
            int packageWeight = scanner.nextInt();
            scanner.nextLine();

            Location location = new Location(locationName, packageWeight);
            locations.addLocation(location);
        }

        squad.sortDronesByCapacity();
        System.out.println("Order by Capacity:");
        DroneSquad.printDrones(squad.drones, squad.droneCount);

        locations.sortLocationsByPackageWeight();
        System.out.println("Order by Package Weight:");
        locations.printLocations(locations.locations, locations.locationsCount);

        squad.assignPackages(locations);
    }
}

