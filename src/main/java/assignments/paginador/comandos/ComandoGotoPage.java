package assignments.paginador.comandos;

import assignments.paginador.PaginatedList;
import assignments.paginador.PaginationController;

public class ComandoGotoPage implements IComando{
    private PaginatedList paginatedList;
    private PaginationController paginationController;
    private Integer numberOfPage = null;

    public ComandoGotoPage(PaginationController paginationController, PaginatedList paginatedList) {
        this.paginatedList = paginatedList;
        this.paginationController = paginationController;
    }
    @Override
    public void setArgumento(String argumento) {
        try {
            this.numberOfPage = Integer.parseInt(argumento);
        } catch (NumberFormatException e) {
            this.numberOfPage = null;
            System.out.println("Error: el argumento debe ser un número");
        }
    }

    @Override
    public void ejecutar() {
        paginationController.showPage(numberOfPage);
    }
}
