package org.norw.notification.observer;

import org.norw.orders.model.Order;
import org.norw.orders.status.OrderStatus;

public interface OrderObserver {
    void onOrderStatusChanged(Order order, OrderStatus oldStatus, OrderStatus newStatus);
}
