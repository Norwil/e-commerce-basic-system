package org.norw.payment.strategy;

import org.norw.payment.model.PaymentResult;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public PaymentResult processPayment(double amount, String customerEmail) {
        if (amount <= 0) {
            return new PaymentResult(false, "Payment amount must be a positive value", null);
        }

        String transactionId = "PP_" + System.currentTimeMillis();

        return new PaymentResult(true, "PayPal payment processed successfully", transactionId);
    }

    @Override
    public String getPaymentMethodName() {
        return "PayPal";
    }
}
