package org.norw.orders.model;

public class RegularOrder extends Order {

    public RegularOrder(String orderId, String customerEmail, double amount) {
        super(orderId, customerEmail, amount);
        this.orderType = "Regular";
    }

    @Override
    public double calculateProcessingFee() {
        return this.amount * 0.02; // 2% of the order amount
    }
}
