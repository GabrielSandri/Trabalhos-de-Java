package com.exemplo.notification.impl;

import com.exemplo.notification.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}