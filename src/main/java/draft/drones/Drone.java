package draft.drones;

public class Drone {
    private String droneName;
    public int capacity;
    int currentLoad = 0;

    public Drone(String droneName, int capacity) {
        this.droneName = droneName;
        this.capacity = capacity;
    }

    public boolean canCarry(int packageWeight) {
        return (currentLoad + packageWeight) <= capacity;
    }

    public void addPackage(int packageWeight) {
        if (canCarry(packageWeight)) {
            currentLoad += packageWeight;
        } else {
            System.out.println("Drone " + this.getDroneName() + " is full and cannot carry more packages.");
        }
    }

    public String getDroneName() {
        return droneName;
    }
}
