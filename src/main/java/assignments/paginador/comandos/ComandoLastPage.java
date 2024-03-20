package assignments.paginador.comandos;

import assignments.paginador.PaginationController;

public class ComandoLastPage implements IComando{
    PaginationController controller;
    public ComandoLastPage(PaginationController controller) {
        this.controller = controller;
    }
    @Override
    public void setArgumento(String argumento) {
        // No necesita argumento
    }

    @Override
    public void ejecutar() {
        controller.lastPage();
    }
}
