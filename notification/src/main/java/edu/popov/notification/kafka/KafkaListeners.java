package edu.popov.notification.kafka;

import edu.popov.clients.notification.NotificationRequest;
import edu.popov.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record KafkaListeners(NotificationService notificationService) {

    @KafkaListener(topics = "modicon", groupId = "groupId", containerFactory = "singleFactory")
    void listener(NotificationRequest data) {
        log.info("Listener received: {}", data);
        notificationService.sendNotification(data);
    }

}
