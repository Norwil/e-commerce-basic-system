package org.norw.payment.strategy;

import org.norw.payment.model.PaymentResult;

public class CryptoPayment implements PaymentStrategy {
    @Override
    public PaymentResult processPayment(double amount, String customerEmail) {
        if (amount <= 0) {
            return new PaymentResult(false, "Amount must be a positive value", null);
        }

        String transactionId = "CRYPTO_" + System.currentTimeMillis();

        return new PaymentResult(true, "Crypt payment has been done successfully", transactionId);
    }

    @Override
    public String getPaymentMethodName() {
        return "Cryptocurrency";
    }
}
