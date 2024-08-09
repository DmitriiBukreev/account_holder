package com.dmitrii.fintech.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class AccountEventConsumer {

    @Incoming("account-events-in")
    public void consume(String event) {
        System.out.println("Received event: " + event);
        // Add logic to process the event (e.g., auditing, logging)
    }
}
