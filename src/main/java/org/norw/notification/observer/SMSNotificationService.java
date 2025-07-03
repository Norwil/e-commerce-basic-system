package org.norw.notification.observer;

import org.norw.orders.model.Order;
import org.norw.orders.status.OrderStatus;

public class SMSNotificationService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(Order order, OrderStatus oldStatus, OrderStatus newStatus) {
        System.out.printf("SMS sent to customer: [%s] is now [%s]%n", order.getOrderId(), newStatus);
    }
}
