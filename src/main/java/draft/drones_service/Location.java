package draft.drones_service;

public class Location {
    private String nombre;
    private double pesoDelPaquete;

    public Location(String nombre, double pesoDelPaquete) {
        this.nombre = nombre;
        this.pesoDelPaquete = pesoDelPaquete;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPesoDelPaquete() {
        return pesoDelPaquete;
    }
}
