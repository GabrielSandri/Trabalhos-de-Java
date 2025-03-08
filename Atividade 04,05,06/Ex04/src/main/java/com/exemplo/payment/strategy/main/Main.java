package com.exemplo.payment.strategy.main;

import com.exemplo.payment.strategy.processor.PaymentProcessor;
import com.exemplo.payment.strategy.impl.PixPayment;
import com.exemplo.payment.strategy.impl.CreditCardPayment;
import com.exemplo.payment.strategy.impl.BoletoPayment;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: PIX");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        int choice = scanner.nextInt();

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1:
                processor.setPaymentStrategy(new PixPayment());
                break;
            case 2:
                processor.setPaymentStrategy(new CreditCardPayment());
                break;
            case 3:
                processor.setPaymentStrategy(new BoletoPayment());
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        processor.processTransaction(amount);
    }
}