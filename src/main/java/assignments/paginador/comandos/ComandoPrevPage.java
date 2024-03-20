package assignments.paginador.comandos;

import assignments.paginador.PaginationController;

public class ComandoPrevPage implements IComando{
    PaginationController controller;
    public ComandoPrevPage(PaginationController controller) {
        this.controller = controller;
    }
    @Override
    public void setArgumento(String argumento) {
        // No necesita argumento
    }

    @Override
    public void ejecutar() {
        controller.prevPage();
    }
}
