package usfx.restaurant.comandos.menu;

import usfx.restaurant.comandos.interfaces.IComando;
import usfx.restaurant.menu.IMenu;
import usfx.restaurant.menu.MenuItem;

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
