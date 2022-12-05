package edu.popov.notification.rabbitmq;

import edu.popov.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record Consumer(NotificationService notificationService) {

//    @RabbitListener(queues = "${rabbitmq.queue.notification}")
//    public void consumer(NotificationRequest notificationRequest) {
//        log.info("Consumed {} from queue", notificationRequest);
//        notificationService.sendNotification(notificationRequest);
//    }

}
