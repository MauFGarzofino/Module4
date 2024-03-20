package assignments.paginador;

import java.util.ArrayList;
import java.util.List;

public class PaginatedList {
    private List<ListItem> items = new ArrayList<>();
    private int pageSize = 10; // Valor predeterminado

    public void addItem(String content) {
        items.add(new ListItem(content));
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Page<ListItem> getPage(int pageNumber) {
        int start = (pageNumber - 1) * pageSize;
        // Para evitar que si la página no está completa no intente imprimir un elemento que no existe
        int end = Math.min(start + pageSize, items.size());
        List<ListItem> pageItems = items.subList(start, end);
        return new Page<>(pageItems, pageNumber, items.size(), pageSize);
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) items.size() / pageSize);
    }
}
