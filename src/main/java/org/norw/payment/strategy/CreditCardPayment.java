package org.norw.payment.strategy;

import org.norw.payment.model.PaymentResult;


public class CreditCardPayment implements PaymentStrategy {
    @Override
    public PaymentResult processPayment(double amount, String customerEmail) {
        // Validate amount > 0
        if (amount <= 0) {
            return new PaymentResult(false, "Payment amount must be positive", null);
        }

        String transactionId = "CC_" + System.currentTimeMillis();

        return new PaymentResult(true, "Credit card payment processed successfully", transactionId);
    }

    @Override
    public String getPaymentMethodName() {
        return "CreditCard";
    }
}
