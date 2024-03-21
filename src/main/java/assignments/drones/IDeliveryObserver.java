package assignments.drones;

import java.util.List;

public interface IDeliveryObserver {
    void update(List<Location> deliveries);
}
