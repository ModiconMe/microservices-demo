package edu.popov.notification;

import edu.popov.clients.notification.NotificationRequest;
import edu.popov.clients.notification.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notifications")
@Slf4j
public record NotificationController(NotificationService notificationService) {

    @PostMapping
    public NotificationResponse sendNotificationToCustomer(@RequestBody NotificationRequest request) {
        log.info("send notification to customer {} at email {}", request.customerId(), request.email());
        return notificationService.sendNotification(request);
    }

}
