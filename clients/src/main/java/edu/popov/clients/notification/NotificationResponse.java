package edu.popov.clients.notification;

import lombok.Builder;

@Builder
public record NotificationResponse(Integer customerId, String text) {
}
