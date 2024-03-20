package assignments.paginador.comandos;

import assignments.paginador.PaginatedList;

public class ComandoAdd implements IComando{

    private PaginatedList list;
    private String itemToAdd; // Campo para almacenar el ítem a añadir

    public ComandoAdd(PaginatedList list) {
        this.list = list;
    }

    @Override
    public void setArgumento(String argumento) {
        this.itemToAdd = argumento; // Guarda el ítem a añadir
    }

    @Override
    public void ejecutar() {
        if (itemToAdd == null || itemToAdd.isEmpty()) {
            System.out.println("No se especificó un item para añadir.");
            return;
        }
        list.addItem(itemToAdd);
        System.out.println("Item añadido: " + itemToAdd);
    }
}
