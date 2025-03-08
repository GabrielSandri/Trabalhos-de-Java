package com.exemplo.notification.main;

import com.exemplo.notification.Notification;
import com.exemplo.notification.factory.NotificationFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a mensagem: ");
        String message = scanner.nextLine();

        NotificationFactory.NotificationType type;
        switch (choice) {
            case 1:
                type = NotificationFactory.NotificationType.EMAIL;
                break;
            case 2:
                type = NotificationFactory.NotificationType.SMS;
                break;
            case 3:
                type = NotificationFactory.NotificationType.PUSH;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        Notification notification = NotificationFactory.createNotification(type);
        notification.send(message);
    }
}