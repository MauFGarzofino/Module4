package assignments.paginador.comandos;

public class ComandoExit implements IComando{
    @Override
    public void setArgumento(String argumento) {
        // Este comando no requiere argumentos
    }

    @Override
    public void ejecutar() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
