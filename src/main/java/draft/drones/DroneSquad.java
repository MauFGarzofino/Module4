package draft.drones;

public class DroneSquad {
    public Drone[] drones;
    public int droneCount;

    public DroneSquad() {
        this.drones = new Drone[100];
        this.droneCount = 0;
    }

    public void addDrone(Drone drone) {
        if (droneCount < drones.length) {
            drones[droneCount] = drone;
            droneCount++;
        }
    }

    public void sortDronesByCapacity() {
        for (int i = 0; i < droneCount - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < droneCount; j++) {
                if (drones[j].capacity > drones[maxIndex].capacity) {
                    maxIndex = j;
                }
            }
            Drone temp = drones[i];
            drones[i] = drones[maxIndex];
            drones[maxIndex] = temp;
        }
    }

    public static void printDrones(Drone[] drones, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(drones[i].getDroneName() + " - Capacity: " + drones[i].capacity);
        }
    }

    public void assignPackages(Locations locations) {
        for (int i = 0; i < locations.locationsCount; i++) {
            Location loc = locations.locations[i];
            boolean assigned = false;

            for (int j = 0; j < droneCount && !assigned; j++) {
                if (drones[j].canCarry(loc.packageWeight)) {
                    drones[j].addPackage(loc.packageWeight);
                    System.out.println(drones[j].getDroneName() + " delivered to " + loc.locationName);
                    assigned = true;
                }
            }
            if (!assigned) {
                System.out.println("No drone can carry the package to " + loc.locationName);
            }
        }
    }
}
