package draft.drones_service;

import java.util.*;

public class App {
    static class Drone {
        String name;
        int maxWeight;
        List<List<String>> trips = new ArrayList<>();
        int currentLoad = 0; // Carga actual en el viaje en curso

        Drone(String name, int maxWeight) {
            this.name = name;
            this.maxWeight = maxWeight;
        }

        // Intenta agregar un paquete al dron. Retorna true si el paquete fue agregado exitosamente.
        boolean addPackage(String location, int weight, int tripIndex) {
            if (trips.size() <= tripIndex) {
                trips.add(new ArrayList<>()); // Asegura que haya un viaje donde agregar el paquete
            }
            List<String> currentTrip = trips.get(tripIndex);
            int tripWeight = currentTrip.stream().mapToInt(pkg -> Integer.parseInt(pkg.split(":")[1])).sum();
            if (tripWeight + weight <= maxWeight) {
                currentTrip.add(location + ":" + weight);
                return true;
            }
            return false; // No se puede llevar el paquete en este viaje
        }
    }

    public static void main(String[] args) {
        // Ejemplo de entrada
        String[] droneInfo = {"Drone1", "150", "Drone2", "100"};
        String[][] packageInfo = {{"Location1", "50"}, {"Location2", "70"}, {"Location3", "30"}, {"Location4", "20"}, {"Location5", "90"}};

        List<Drone> drones = new ArrayList<>();
        for (int i = 0; i < droneInfo.length; i += 2) {
            drones.add(new Drone(droneInfo[i], Integer.parseInt(droneInfo[i + 1])));
        }

        List<String[]> packages = Arrays.asList(packageInfo);
        packages.sort((a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));

        // Asignar paquetes intentando distribuir equitativamente entre los viajes de los drones
        int tripIndex = 0;
        boolean allPackagesAssigned;
        do {
            allPackagesAssigned = true;
            for (String[] pkg : packages) {
                String location = pkg[0];
                int weight = Integer.parseInt(pkg[1]);
                boolean assigned = false;
                for (Drone drone : drones) {
                    if (drone.addPackage(location, weight, tripIndex)) {
                        assigned = true;
                        break;
                    }
                }
                allPackagesAssigned &= assigned;
            }
            tripIndex++;
        } while (!allPackagesAssigned);

        // Imprimir los resultados
        for (Drone drone : drones) {
            System.out.println(drone.name);
            int tripNum = 1;
            for (List<String> trip : drone.trips) {
                System.out.println("Trip #" + tripNum++);
                trip.forEach(pkg -> System.out.println(pkg.split(":")[0] + ", Peso: " + pkg.split(":")[1]));
            }
        }
    }
}