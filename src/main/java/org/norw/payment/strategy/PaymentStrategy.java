package org.norw.payment.strategy;

import org.norw.payment.model.PaymentResult;

public interface PaymentStrategy {
    PaymentResult processPayment(double amount, String customerEmail);
    String getPaymentMethodName();
}
