package com.exemplo.payment.strategy.main;

import com.exemplo.payment.factory.PaymentFactory;
import com.exemplo.payment.strategy.processor.PaymentProcessor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: PIX");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();

        PaymentFactory.PaymentType type;
        switch (choice) {
            case 1:
                type = PaymentFactory.PaymentType.PIX;
                break;
            case 2:
                type = PaymentFactory.PaymentType.CREDIT_CARD;
                break;
            case 3:
                type = PaymentFactory.PaymentType.BOLETO;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        PaymentProcessor processor = new PaymentProcessor();
        processor.setPaymentStrategy(PaymentFactory.createPayment(type));
        processor.processTransaction(amount);
    }
}

