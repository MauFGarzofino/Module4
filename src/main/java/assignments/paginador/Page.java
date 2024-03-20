package assignments.paginador;

import java.util.List;

public class Page<T> {
    private List<T> items;
    private int pageNumber;
    private int totalItems;
    private int pageSize;

    public Page(List<T> items, int pageNumber, int totalItems, int pageSize) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.totalItems = totalItems;
        this.pageSize = pageSize;
    }

    public void print() {
        System.out.println("Page " + pageNumber + " of " + getTotalPages());
        for (T item : items) {
            System.out.println(item);
        }
    }

    private int getTotalPages() {
        return (int) Math.ceil((double) totalItems / pageSize);
    }
}
