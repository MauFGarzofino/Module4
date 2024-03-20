package assignments.restaurant.comandos;

import assignments.restaurant.comandos.menu.ComandoAdicionarItemsAlMenu;
import assignments.restaurant.comandos.menu.ComandoActualizarItemDelMenu;
import assignments.restaurant.comandos.menu.ComandoVerMenu;
import assignments.restaurant.comandos.orden.ComandoAnadirItemAOrden;
import assignments.restaurant.comandos.orden.ComandoRemoveOrden;
import assignments.restaurant.comandos.orden.ComandoVerOrden;
import assignments.restaurant.menu.IMenu;
import assignments.restaurant.order.IOrder;

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
