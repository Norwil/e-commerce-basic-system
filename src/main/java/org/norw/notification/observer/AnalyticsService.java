package org.norw.notification.observer;

import org.norw.orders.model.Order;
import org.norw.orders.status.OrderStatus;

public class AnalyticsService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(Order order, OrderStatus oldStatus, OrderStatus newStatus) {
        System.out.printf("Order [%s] moved from [%s] to [%s]", order.getOrderId(), oldStatus, newStatus);
    }
}
