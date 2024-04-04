package com.example.Notifications.kafka;

import com.example.Notifications.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final NotificationService service;

    @KafkaListener(topics = "sent_orders")
    public void consume(String order) {
        log.info("Заказ уехал клиенту: {}", order);
        service.payOrder(order);
    }
}
