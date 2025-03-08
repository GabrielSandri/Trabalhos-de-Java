package com.exemplo.payment.strategy.impl;

import com.exemplo.payment.strategy.PaymentStrategy;
import java.util.UUID;

public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String pixCode = UUID.randomUUID().toString();
        System.out.println("Pagamento via PIX no valor de R$" + amount + " processado.");
        System.out.println("Código PIX: " + pixCode);
    }
}