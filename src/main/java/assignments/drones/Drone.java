package assignments.drones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Drone implements IDeliveryObserver {
    private String name;
    private int maxWeight;
    private List<List<Location>> trips = new ArrayList<>();

    public Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
    }

    @Override
    public void update(List<Location> deliveries) {
        trips.add(new ArrayList<>(deliveries));

        // Construir una cadena con los nombres de las localizaciones
        StringBuilder deliveryNames = new StringBuilder();
        for (int i = 0; i < deliveries.size(); i++) {
            deliveryNames.append(deliveries.get(i).getName());
            if (i < deliveries.size() - 1) { // Para evitar añadir una coma al final
                deliveryNames.append(", ");
            }
        }

        System.out.println(name + ": " + deliveryNames);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}