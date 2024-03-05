package usfx.drones_service;

import java.util.ArrayList;
import java.util.List;

public class Drone {
    private String nombre;
    private double capacidadMaxima;
    private List<Trip> entregas;

    public Drone(String nombre, double capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.entregas = new ArrayList<>();
    }

    public void asignarEntrega(Location loc) {
        // Implementación simplificada, se debe mejorar para optimizar la asignación
        if (entregas.isEmpty() || !agregarALastTrip(loc)) {
            Trip nuevoTrip = new Trip();
            nuevoTrip.agregarUbicacion(loc);
            entregas.add(nuevoTrip);
        }
    }

    private boolean agregarALastTrip(Location loc) {
        Trip lastTrip = entregas.get(entregas.size() - 1);
        if (lastTrip.obtenerPesoTotal() + loc.getPesoDelPaquete() <= capacidadMaxima) {
            lastTrip.agregarUbicacion(loc);
            return true;
        }
        return false;
    }

    public boolean puedeAgregar(Location loc) {
        // Verificar si la última entrega puede tomar esta ubicación
        if (!entregas.isEmpty()) {
            Trip ultimoViaje = entregas.get(entregas.size() - 1);
            if (ultimoViaje.obtenerPesoTotal() + loc.getPesoDelPaquete() <= capacidadMaxima) {
                return true;
            }
        }
        // O si un nuevo viaje puede ser iniciado con esta ubicación
        return loc.getPesoDelPaquete() <= capacidadMaxima;
    }

    public List<Trip> getEntregas() {
        return entregas;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
