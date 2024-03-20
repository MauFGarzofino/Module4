package assignments.restaurant.comandos;

import assignments.restaurant.comandos.interfaces.IComando;

public class ComandoSalir implements IComando {
    @Override
    public void ejecutar() {
        System.out.println("Exiting the Restaurant Management System.");
        System.exit(0);
    }
}
