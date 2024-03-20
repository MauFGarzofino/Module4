package assignments.restaurant.comandos.orden;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.order.IOrder;
import assignments.restaurant.order.OrderItem;

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
