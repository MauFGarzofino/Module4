package assignments.restaurant.menu;

import java.util.List;

public interface IMenu {
    void addItem(MenuItem menuItem);
    List<MenuItem> getItems();
    MenuItem findItemByName(String name);
    void updateItem(String name, double newPrice, String newDescription);
}
