package assignments.drones;

import java.util.List;

public interface IDeliveryStrategy {
    void assignDeliveries(List<Drone> drones, List<Location> locations);
}
