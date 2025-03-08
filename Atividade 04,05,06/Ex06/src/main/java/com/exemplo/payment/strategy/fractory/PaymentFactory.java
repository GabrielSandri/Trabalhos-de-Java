package com.exemplo.payment.factory;

import com.exemplo.payment.strategy.PaymentStrategy;
import com.exemplo.payment.strategy.impl.PixPayment;
import com.exemplo.payment.strategy.impl.CreditCardPayment;
import com.exemplo.payment.strategy.impl.BoletoPayment;

public class PaymentFactory {
    public enum PaymentType {
        PIX, CREDIT_CARD, BOLETO
    }

    public static PaymentStrategy createPayment(PaymentType type) {
        switch (type) {
            case PIX:
                return new PixPayment();
            case CREDIT_CARD:
                return new CreditCardPayment();
            case BOLETO:
                return new BoletoPayment();
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido: " + type);
        }
    }
}