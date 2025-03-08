package com.exemplo.payment.strategy.processor;
import com.exemplo.payment.strategy.PaymentStrategy;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processTransaction(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(amount);
        } else {
            System.out.println("Nenhum método de pagamento selecionado.");
        }
    }
}
