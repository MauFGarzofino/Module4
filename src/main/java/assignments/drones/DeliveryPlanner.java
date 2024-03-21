package assignments.drones;

import java.util.List;

public class DeliveryPlanner {
    private IDeliveryStrategy strategy;

    public DeliveryPlanner(IDeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public void planDeliveries(List<Drone> drones, List<Location> locations) {
        strategy.assignDeliveries(drones, locations);
    }
}

