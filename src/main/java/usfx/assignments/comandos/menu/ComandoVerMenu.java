package usfx.assignments.comandos.menu;

import usfx.assignments.comandos.interfaces.IComando;
import usfx.assignments.menu.IMenu;
import usfx.assignments.menu.MenuItem;

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
