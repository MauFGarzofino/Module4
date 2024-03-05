package usfx.drones_service;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private List<Location> ubicaciones;

    public Trip() {
        this.ubicaciones = new ArrayList<>();
    }

    public void agregarUbicacion(Location loc) {
        ubicaciones.add(loc);
    }

    public double obtenerPesoTotal() {
        return ubicaciones.stream().mapToDouble(Location::getPesoDelPaquete).sum();
    }

    public List<Location> getUbicaciones() {
        return ubicaciones;
    }
}
