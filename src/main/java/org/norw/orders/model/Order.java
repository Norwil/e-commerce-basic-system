package org.norw.orders.model;

import java.time.LocalDateTime;

public abstract class Order {
    protected String orderId;
    protected String customerEmail;
    protected double amount;
    protected String orderType;
    protected LocalDateTime createdAt;

    public Order(String orderId, String customerEmail, double amount) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }

    public abstract double calculateProcessingFee();

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public double getAmount() {
        return amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderType='" + orderType + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
