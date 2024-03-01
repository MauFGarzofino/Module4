package usfx.drones;

public class Locations {
    public Location[] locations;
    public int locationsCount;

    public Locations() {
        this.locations = new Location[200];
        this.locationsCount = 0;
    }

    public void addLocation(Location location) {
        if(locationsCount < locations.length) {
            locations[locationsCount] = location;
            locationsCount++;
        }
    }

    public void sortLocationsByPackageWeight() {
        for (int i = 0; i < locationsCount - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < locationsCount; j++) {
                if (this.locations[j].packageWeight > locations[maxIndex].packageWeight) {
                    maxIndex = j;
                }
            }
            Location temp = locations[i];
            locations[i] = locations[maxIndex];
            locations[maxIndex] = temp;
        }
    }

    public void printLocations(Location[] location, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(location[i].locationName + " - Package Weight: " + location[i].packageWeight);
        }
    }
}
