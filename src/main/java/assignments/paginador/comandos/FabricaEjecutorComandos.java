package assignments.paginador.comandos;


import assignments.paginador.PaginatedList;
import assignments.paginador.PaginationController;

public class FabricaEjecutorComandos {
    public static EjecutorComandos crearEjecutorConComandos(PaginatedList list, PaginationController paginationController) {
        EjecutorComandos ejecutorComandos = new EjecutorComandos();

        ejecutorComandos.adicionarComando("add", new ComandoAdd(list));
        ejecutorComandos.adicionarComando("first", new ComandoFirstPage(paginationController));
        ejecutorComandos.adicionarComando("last", new ComandoLastPage(paginationController));
        ejecutorComandos.adicionarComando("next", new ComandoNextPage(paginationController));
        ejecutorComandos.adicionarComando("prev", new ComandoPrevPage(paginationController));
        ejecutorComandos.adicionarComando("goto", new ComandoGotoPage(paginationController, list));
        ejecutorComandos.adicionarComando("setsize", new ComandoSetSize(list));
        ejecutorComandos.adicionarComando("exit", new ComandoExit());

        return ejecutorComandos;
    }
}

