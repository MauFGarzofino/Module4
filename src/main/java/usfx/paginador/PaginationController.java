package usfx.paginador;

public class PaginationController {
    private PaginatedList paginatedList;
    private static int currentPage;

    public PaginationController(PaginatedList paginatedList) {
        this.paginatedList = paginatedList;
        this.currentPage = 1; // Iniciar en la primera página
    }

    public void firstPage() {
        currentPage = 1;
        paginatedList.getPage(currentPage).print();
    }

    public void lastPage() {
        currentPage = paginatedList.getTotalPages();
        paginatedList.getPage(currentPage).print();
    }

    public void nextPage() {
        if (currentPage < paginatedList.getTotalPages()) {
            currentPage++;
            paginatedList.getPage(currentPage).print();
        } else {
            System.out.println("Already on the last page.");
        }
        }

    public void prevPage() {
        if (currentPage > 1) {
            currentPage--;
            paginatedList.getPage(currentPage).print();
        } else {
            System.out.println("Already on the first page.");
        }
    }

    public void showPage(int pageNumber) {
        if (pageNumber >= 1 && pageNumber <= paginatedList.getTotalPages()) {
            currentPage = pageNumber;
            showCurrentPage();
        } else {
            System.out.println("Invalid page number.");
        }
    }

    private void showCurrentPage() {
        Page<ListItem> page = paginatedList.getPage(currentPage);
        if (page != null) {
            page.print();
        } else {
            System.out.println("Page is empty.");
        }
    }
}

