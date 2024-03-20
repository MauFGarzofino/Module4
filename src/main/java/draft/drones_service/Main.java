package draft.drones_service;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear drones
        Drone drone1 = new Drone("Drone1", 100.0);
        Drone drone2 = new Drone("Drone2", 150.0);

        // Crear ubicaciones
        Location loc1 = new Location("Ubicación1", 40.0);
        Location loc2 = new Location("Ubicación2", 60.0);
        Location loc3 = new Location("Ubicación3", 80.0);
        Location loc4 = new Location("Ubicación4", 20.0);
        Location loc5 = new Location("Ubicación5", 50.0);

        // Lista de drones y ubicaciones
        List<Drone> drones = Arrays.asList(drone1, drone2);
        List<Location> locations = Arrays.asList(loc1, loc2, loc3, loc4, loc5);

        // Optimizar entregas
        DeliveryOptimizer.optimizarEntregas(drones, locations);

        // Imprimir resultados
        imprimirResultados(drones);
    }

    private static void imprimirResultados(List<Drone> drones) {
        for (Drone drone : drones) {
            System.out.println(drone.getNombre() + ":");
            List<Trip> viajes = drone.getEntregas();
            for (int i = 0; i < viajes.size(); i++) {
                System.out.println("Viaje #" + (i + 1));
                List<Location> ubicaciones = viajes.get(i).getUbicaciones();
                for (Location loc : ubicaciones) {
                    System.out.println(loc.getNombre() + ", Peso: " + loc.getPesoDelPaquete());
                }
            }
        }
    }
}

