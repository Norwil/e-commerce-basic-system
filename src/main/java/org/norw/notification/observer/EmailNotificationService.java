package org.norw.notification.observer;

import org.norw.orders.model.Order;
import org.norw.orders.status.OrderStatus;

public class EmailNotificationService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(Order order, OrderStatus oldStatus, OrderStatus newStatus) {
        System.out.printf("Email sent to [%s]: Order [%s] status changed to [%s]%n", order.getCustomerEmail(), order.getOrderId(), newStatus);
    }
}
