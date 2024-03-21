package assignments.drones;

import java.util.ArrayList;
import java.util.List;

public class EfficientDeliveryStrategy implements IDeliveryStrategy {
    @Override
    public void assignDeliveries(List<Drone> drones, List<Location> locations) {
        int numberOfTrip = 1;
        while (!locations.isEmpty()) {
            System.out.println("Trip #" + numberOfTrip);
            boolean anyDeliveriesAssigned = assignDeliveriesToDrones(drones, locations);

            if (!anyDeliveriesAssigned) {
                System.out.println("Una o más localizaciones sobrepasan la capacidad máxima de los drones");
                break;
            }
            numberOfTrip++;
        }
    }

    private boolean assignDeliveriesToDrones(List<Drone> drones, List<Location> locations) {
        sortDronesByMaxWeight(drones);
        sortLocationsByPackageWeight(locations);

        boolean anyDeliveriesAssigned = false;
        for (Drone drone : drones) {
            List<Location> deliveriesForDrone = calculateDeliveriesForDrone(drone, locations);
            if (!deliveriesForDrone.isEmpty()) {
                drone.update(deliveriesForDrone);
                anyDeliveriesAssigned = true;
            }
        }
        return anyDeliveriesAssigned;
    }

    private List<Location> calculateDeliveriesForDrone(Drone drone, List<Location> locations) {
        int availableCapacity = drone.getMaxWeight();
        List<Location> deliveriesForDrone = new ArrayList<>();
        List<Location> locationsToRemove = new ArrayList<>();

        for (Location location : locations) {
            if (location.getPackageWeight() <= availableCapacity) {
                availableCapacity -= location.getPackageWeight();
                deliveriesForDrone.add(location);
                locationsToRemove.add(location);
            }
        }

        locations.removeAll(locationsToRemove);

        return deliveriesForDrone;
    }

    public void sortDronesByMaxWeight(List<Drone> drones) {
        for (int i = 0; i < drones.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < drones.size(); j++) {
                if (drones.get(j).getMaxWeight() > drones.get(maxIndex).getMaxWeight()) {
                    maxIndex = j;
                }
            }

            if (i != maxIndex) {
                Drone temp = drones.get(i);
                drones.set(i, drones.get(maxIndex));
                drones.set(maxIndex, temp);
            }
        }
    }

    public void sortLocationsByPackageWeight(List<Location> locations) {
        for (int i = 0; i < locations.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < locations.size(); j++) {
                if (locations.get(j).getPackageWeight() > locations.get(maxIndex).getPackageWeight()) {
                    maxIndex = j;
                }
            }

            if (i != maxIndex) {
                Location temp = locations.get(i);
                locations.set(i, locations.get(maxIndex));
                locations.set(maxIndex, temp);
            }
        }
    }
}
