package edu.popov.clients.notification;

import lombok.Builder;

@Builder
public record NotificationRequest(
        Integer customerId,
        String text,
        String email
) {
}
