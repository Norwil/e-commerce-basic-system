package org.norw.service;

import org.norw.notification.observer.OrderObserver;
import org.norw.orders.model.Order;
import org.norw.orders.model.RegularOrder;
import org.norw.orders.status.OrderStatus;
import org.norw.payment.model.PaymentResult;
import org.norw.payment.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessingService {
    private List<OrderObserver> observers;
    private PaymentStrategy paymentStrategy;
    private Map<String, OrderStatus> orderStatuses;

    public OrderProcessingService() {
        this.observers = new ArrayList<>();
        this.orderStatuses = new HashMap<>();
    }

    public void addObserver(OrderObserver observer) {
        this.observers.add(observer);
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    private void notifyObservers(Order order, OrderStatus oldStatus, OrderStatus newStatus) {
        for (OrderObserver observer : observers) {
            observer.onOrderStatusChanged(order, oldStatus, newStatus);
        }
    }

    // Process an order through its lifecycle
    public void processOrder(Order order) {
        // Initial status
        updateOrderStatus(order.getOrderId(), OrderStatus.CREATED);

        // Change to Processing status
        updateOrderStatus(order.getOrderId(), OrderStatus.PAYMENT_PROCESSING);

        // Process Payment
        PaymentResult result = paymentStrategy.processPayment(order.getAmount(), order.getCustomerEmail());

        // Update status based on payment result
        if (result.isSuccess()) {
            updateOrderStatus(order.getOrderId(), OrderStatus.PAID);
        } else {
            updateOrderStatus(order.getOrderId(), OrderStatus.CANCELLED);
        }
    }


    // Update order status and notify observers
    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
        OrderStatus oldStatus = orderStatuses.getOrDefault(orderId, null);
        orderStatuses.put(orderId, newStatus);

        // Minimal Order for notification
        Order order = new RegularOrder(orderId, "dummy@email.com", 0.0) {
            @Override
            public double calculateProcessingFee() { return 0; }
        };

        notifyObservers(order, oldStatus, newStatus);
    }
}
