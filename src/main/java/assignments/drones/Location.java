package assignments.drones;

public class Location {
    private String name;
    private int packageWeight;

    public Location(String name, int packageWeight) {
        this.name = name;
        this.packageWeight = packageWeight;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPackageWeight() {
        return packageWeight;
    }
}
