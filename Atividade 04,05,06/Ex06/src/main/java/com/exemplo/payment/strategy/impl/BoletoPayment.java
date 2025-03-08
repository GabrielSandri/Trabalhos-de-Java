package com.exemplo.payment.strategy.impl;

import com.exemplo.payment.strategy.PaymentStrategy;
import java.util.UUID;

public class BoletoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String boletoCode = UUID.randomUUID().toString();
        System.out.println("Pagamento via Boleto no valor de R$" + amount + " processado.");
        System.out.println("Código do Boleto: " + boletoCode);
    }
}