package org.norw.notification.observer;

import org.norw.orders.model.Order;
import org.norw.orders.status.OrderStatus;

public class InventoryService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(Order order, OrderStatus oldStatus, OrderStatus newStatus) {
        if (newStatus == OrderStatus.PAID) {
            System.out.printf("Inventory updated for order [%s]", order.getOrderId());
        } else if (newStatus == OrderStatus.CANCELLED) {
            System.out.printf("Inventory restored for order [%s]", order.getOrderId());
        }
    }
}
