package assignments.paginador.comandos;

import assignments.paginador.PaginatedList;

public class ComandoSetSize implements IComando{
    private PaginatedList paginatedList;
    private Integer size = null; // Uso de Integer para poder verificar si se estableció un valor
    public ComandoSetSize (PaginatedList paginatedList) {
        this.paginatedList = paginatedList;
    }

    @Override
    public void setArgumento(String argumento) {
        try {
            this.size = Integer.parseInt(argumento);
        } catch (NumberFormatException e) {
            this.size = null;
            System.out.println("Error: el argumento para setsize debe ser un número entero.");
        }
    }

    @Override
    public void ejecutar() {
        if (size != null) {
            paginatedList.setPageSize(size);
            System.out.println("Tamaño de página establecido a: " + size);
        } else {
            System.out.println("Error: No se ha establecido un tamaño de página válido");
        }
    }
}
