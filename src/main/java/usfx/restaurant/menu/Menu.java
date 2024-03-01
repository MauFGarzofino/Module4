package usfx.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements IMenu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public MenuItem findItemByName(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void updateItem(String name, double newPrice, String newDescription) {
        MenuItem item = findItemByName(name);
        if (item != null) {
            item.setPrice(newPrice);
            item.setDescription(newDescription);
        } else {
            System.out.println("Item not found");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menu:\n");
        for (MenuItem item : items) {
            sb.append(item.getName()).append(" - Bs").append(item.getPrice()).append(" - ").append(item.getDescription()).append("\n");
        }
        return sb.toString();
    }
}