package assignments.paginador.comandos;

import assignments.paginador.PaginationController;

public class ComandoNextPage implements IComando {
    PaginationController controller;
    public ComandoNextPage(PaginationController controller) {
        this.controller = controller;
    }
    @Override
    public void setArgumento(String argumento) {
        // No necesita argumento
    }

    @Override
    public void ejecutar() {
        controller.nextPage();
    }
}
