package edu.popov.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification")
public interface NotificationClient {

    @PostMapping("api/v1/notifications")
    public NotificationResponse sendNotificationToCustomer(@RequestBody NotificationRequest request);

}
