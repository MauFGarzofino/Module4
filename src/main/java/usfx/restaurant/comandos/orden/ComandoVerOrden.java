package usfx.restaurant.comandos.orden;

import usfx.restaurant.comandos.interfaces.IComando;
import usfx.restaurant.order.IOrder;
import usfx.restaurant.order.OrderItem;

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
