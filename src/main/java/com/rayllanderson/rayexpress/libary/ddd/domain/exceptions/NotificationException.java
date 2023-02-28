package com.rayllanderson.rayexpress.libary.ddd.domain.exceptions;


import com.rayllanderson.rayexpress.libary.ddd.domain.validation.handler.Notification;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }
}
