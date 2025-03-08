package com.exemplo.notification.impl;

import com.exemplo.notification.Notification;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando notificação push: " + message);
    }
}