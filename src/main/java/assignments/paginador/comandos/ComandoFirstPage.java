package assignments.paginador.comandos;

import assignments.paginador.PaginationController;

public class ComandoFirstPage implements IComando{

    PaginationController controller;
    public ComandoFirstPage(PaginationController controller) {
        this.controller = controller;
    }
    @Override
    public void setArgumento(String argumento) {
        // No necesita argumento
    }

    @Override
    public void ejecutar() {
        controller.firstPage();
    }
}
