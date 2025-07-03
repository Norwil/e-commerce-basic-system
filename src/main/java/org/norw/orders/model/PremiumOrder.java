package org.norw.orders.model;

public class PremiumOrder extends Order {

    public PremiumOrder(String orderId, String customerEmail, double amount) {
        super(orderId, customerEmail, amount);
        this.orderType = "Premium";
    }

    @Override
    public double calculateProcessingFee() {
        return this.amount * 0.01; // 1% of amount discount
    }
}
