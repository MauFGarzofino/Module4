package usfx.assignments.comandos;

import usfx.assignments.comandos.menu.ComandoActualizarItemDelMenu;
import usfx.assignments.comandos.menu.ComandoAdicionarItemsAlMenu;
import usfx.assignments.comandos.menu.ComandoVerMenu;
import usfx.assignments.comandos.orden.ComandoAnadirItemAOrden;
import usfx.assignments.comandos.orden.ComandoRemoveOrden;
import usfx.assignments.comandos.orden.ComandoVerOrden;
import usfx.assignments.menu.IMenu;
import usfx.assignments.order.IOrder;

public class FabricaEjecutorComandos {
    public static EjecutorComandos crearEjecutorConComandos(IMenu menu, IOrder order) {
        EjecutorComandos ejecutor = new EjecutorComandos();

        //Menu
        ejecutor.adicionarComando("adicionarMenu", new ComandoAdicionarItemsAlMenu(menu));
        ejecutor.adicionarComando("verMenu", new ComandoVerMenu(menu));
        ejecutor.adicionarComando("actualizarMenu", new ComandoActualizarItemDelMenu(menu));

        //Order
        ejecutor.adicionarComando("añadirItemAOrden", new ComandoAnadirItemAOrden(menu, order));
        ejecutor.adicionarComando("verOrden", new ComandoVerOrden(order));
        ejecutor.adicionarComando("removerOrden", new ComandoRemoveOrden(order));

        return ejecutor;
    }
}
