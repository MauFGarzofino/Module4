package usfx.dronesfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DroneDeliverySystem {

    public static void main(String[] args) {
        // Ejemplo de paquetes y drones
        List<Package> packages = Arrays.asList(new Package("Location1", 50), new Package("Location2", 70),
                new Package("Location3", 30), new Package("Location4", 70),
                new Package("Location6", 70), new Package("Location7", 100), new Package("Location8", 50));
        List<Drone> drones = Arrays.asList(new Drone("Drone1", 200), new Drone("Drone2", 150));

        // La creación de pilas ya no se basa en una capacidad máxima fija
        List<Pile> piles = createPiles(packages);
        assignPilesToDrones(piles, drones);

        // Mostrar la asignación de pilas a drones
        for (Drone drone : drones) {
            System.out.println("Drone: " + drone.name);
            for (Pile pile : drone.assignedPiles) {
                System.out.println("Pile: " + pile.packages.stream().map(p -> p.location).toList());
            }
        }
    }

    static List<Pile> createPiles(List<Package> packages) {
        // Ordenar paquetes por peso descendente
        packages.sort((p1, p2) -> p2.weight - p1.weight);
        List<Pile> piles = new ArrayList<>();

        // Simplemente crear una pila por cada paquete
        for (Package pkg : packages) {
            Pile newPile = new Pile();
            newPile.addPackage(pkg); // Ajustado para no requerir maxCapacity
            piles.add(newPile);
        }
        return piles;
    }

    static void assignPilesToDrones(List<Pile> piles, List<Drone> drones) {
        // Asegurarse de que cada pila sea considerada para la asignación.
        piles.forEach(pile -> {
            Drone bestDrone = null;
            int bestFitRemainingCapacity = Integer.MAX_VALUE;

            for (Drone drone : drones) {
                int remainingCapacity = drone.maxWeight - drone.currentLoad;
                int pileWeight = pile.getTotalWeight();
                if (remainingCapacity >= pileWeight && remainingCapacity < bestFitRemainingCapacity) {
                    bestFitRemainingCapacity = remainingCapacity;
                    bestDrone = drone;
                }
            }

            if (bestDrone != null) {
                bestDrone.assignPile(pile);
            } else {
                System.out.println("No se encontró un dron para la pila con peso total: " + pile.getTotalWeight());
            }
        });
    }
}
