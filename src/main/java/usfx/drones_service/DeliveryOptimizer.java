package usfx.drones_service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeliveryOptimizer {

    public static void optimizarEntregas(List<Drone> drones, List<Location> locations) {
        // Ordenar las ubicaciones por peso descendente
        Collections.sort(locations, (loc1, loc2) -> Double.compare(loc2.getPesoDelPaquete(), loc1.getPesoDelPaquete()));

        // Ordenar los drones por capacidad ascendente
        Collections.sort(drones, (drone1, drone2) -> Double.compare(drone1.getCapacidadMaxima(), drone2.getCapacidadMaxima()));

        for (Location loc : locations) {
            boolean entregado = false;
            for (Drone drone : drones) {
                if (drone.puedeAgregar(loc)) { // Necesitamos implementar este método en Drone
                    drone.asignarEntrega(loc);
                    entregado = true;
                    break;
                }
            }
            if (!entregado) {
                System.out.println("No se pudo asignar la ubicación " + loc.getNombre() + " debido a limitaciones de capacidad.");
            }
        }
    }
}


