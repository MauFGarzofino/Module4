package assignments.paginador;

public class ListItem {
    private String content;

    public ListItem(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
