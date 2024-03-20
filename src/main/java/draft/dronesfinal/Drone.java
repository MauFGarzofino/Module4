package draft.dronesfinal;

import java.util.ArrayList;
import java.util.List;

public class Drone {
    String name;
    int maxWeight;
    int currentLoad = 0; // Carga actual
    List<Pile> assignedPiles = new ArrayList<>();

    Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
    }

    void assignPile(Pile pile) {
        assignedPiles.add(pile);
    }

    int getRemainingCapacity() {
        return maxWeight - currentLoad;
    }

}
