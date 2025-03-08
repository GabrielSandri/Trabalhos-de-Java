package com.exemplo.notification.factory;

import com.exemplo.notification.Notification;
import com.exemplo.notification.impl.EmailNotification;
import com.exemplo.notification.impl.SMSNotification;
import com.exemplo.notification.impl.PushNotification;

public class NotificationFactory {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    public static Notification createNotification(NotificationType type) {
        switch (type) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Tipo de notificação inválido: " + type);
        }
    }
}