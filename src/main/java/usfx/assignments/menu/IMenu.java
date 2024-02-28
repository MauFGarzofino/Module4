package usfx.assignments.menu;

import java.util.List;

public interface IMenu {
    void addItem(MenuItem menuItem);
    List<MenuItem> getItems();
    MenuItem findItemByName(String name);
}
