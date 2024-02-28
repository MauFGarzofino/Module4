package usfx.assignments.comandos.orden;

import usfx.assignments.comandos.interfaces.IComando;
import usfx.assignments.menu.MenuItem;
import usfx.assignments.order.IOrder;
import usfx.assignments.order.OrderItem;

public class ComandoVerOrden implements IComando {

    private IOrder order;

    public ComandoVerOrden(IOrder order) {
        this.order = order;
    }

    @Override
    public void ejecutar() {
        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item.getItem().getName() + ": " + item.getSpecialRequest());
        }
    }
}
