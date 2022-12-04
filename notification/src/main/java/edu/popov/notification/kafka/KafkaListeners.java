package edu.popov.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "modicon", groupId = "groupId", containerFactory = "singleFactory")
    void listener(Object data) {
        System.out.println("Listener received: " + data);
    }

}
