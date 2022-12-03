package edu.popov.notification;

import edu.popov.clients.notification.NotificationRequest;
import edu.popov.clients.notification.NotificationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public NotificationResponse sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .customerId(request.customerId())
                .text(request.text())
                .email(request.email())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
        return NotificationResponse.builder()
                .customerId(request.customerId())
                .text(request.text())
                .build();
    }

}
