package com.exemplo.payment.strategy.impl;

import com.exemplo.payment.strategy.PaymentStrategy;
import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão (fictício): ");
        String cardNumber = scanner.nextLine();
        System.out.println("Pagamento no valor de R$" + amount + " processado com o cartão " + cardNumber);
    }
}