package draft.dronesfinal;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    List<Package> packages = new ArrayList<>();
    int totalWeight = 0;

    boolean addPackage(Package pkg) {
        packages.add(pkg);
        totalWeight += pkg.weight;
        return true;
    }
    public int getTotalWeight() {
        return totalWeight; // Ya calculamos totalWeight en tiempo real
    }
}