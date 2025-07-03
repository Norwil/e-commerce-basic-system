package org.norw.orders.model;

public class GiftOrder extends Order {
    public GiftOrder(String orderId, String customerEmail, double amount) {
        super(orderId, customerEmail, amount);
        this.orderType = "Gift";
    }

    @Override
    public double calculateProcessingFee() {
        return this.amount * 0.03; // 3% discount
    }
}
