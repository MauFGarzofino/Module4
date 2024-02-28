package usfx.assignments.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements IMenu{
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

    public void updateItem(int index, MenuItem item) {
        if (index >= 0 && index < items.size()) {
            items.set(index, item);
        } else {
            System.out.println("Out of range");
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            System.out.println("Out of range");
        }
    }


    // toString() ?
}