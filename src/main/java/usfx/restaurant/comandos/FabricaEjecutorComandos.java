package usfx.restaurant.comandos;

import usfx.restaurant.comandos.menu.ComandoActualizarItemDelMenu;
import usfx.restaurant.comandos.menu.ComandoAdicionarItemsAlMenu;
import usfx.restaurant.comandos.menu.ComandoVerMenu;
import usfx.restaurant.comandos.orden.ComandoAnadirItemAOrden;
import usfx.restaurant.comandos.orden.ComandoRemoveOrden;
import usfx.restaurant.comandos.orden.ComandoVerOrden;
import usfx.restaurant.menu.IMenu;
import usfx.restaurant.order.IOrder;

public class FabricaEjecutorComandos {
    public static EjecutorComandos crearEjecutorConComandos(IMenu menu, IOrder order) {
        EjecutorComandos ejecutor = new EjecutorComandos();

        ejecutor.adicionarComando("exit", new ComandoSalir());
        //Menu
        ejecutor.adicionarComando("addMenu", new ComandoAdicionarItemsAlMenu(menu));
        ejecutor.adicionarComando("showMenu", new ComandoVerMenu(menu));
        ejecutor.adicionarComando("updateMenu", new ComandoActualizarItemDelMenu(menu));

        //Order
        ejecutor.adicionarComando("addItem", new ComandoAnadirItemAOrden(menu, order));
        ejecutor.adicionarComando("showOrder", new ComandoVerOrden(order));
        ejecutor.adicionarComando("removeItem", new ComandoRemoveOrden(order));

        return ejecutor;
    }
}
