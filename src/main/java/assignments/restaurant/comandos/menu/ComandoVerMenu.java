package assignments.restaurant.comandos.menu;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.menu.IMenu;
import assignments.restaurant.menu.MenuItem;

public class ComandoVerMenu implements IComando {

    private IMenu menu;

    public ComandoVerMenu(IMenu menu) {
        this.menu = menu;
    }
    @Override
    public void ejecutar() {
        for (MenuItem item : menu.getItems()) {
            System.out.println(item.getName() + ": " + item.getPrice() + " " + item.getDescription());
        }
    }
}
