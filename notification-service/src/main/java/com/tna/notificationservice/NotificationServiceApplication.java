package com.tna.notificationservice;

import com.tna.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@SpringBootApplication
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notification", groupId = "notificationConsumerGroup")
    public void notificationConsumer(OrderPlacedEvent event) {
      log.info("Received notification for order: {}", event.getOrderNumber());
    }
}
