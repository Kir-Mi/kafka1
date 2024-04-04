package com.example.Shipping.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${application.kafka.producer.topic}")
    private String topic;

    public void sendMessage(String order) {
        log.info("Заказ отправлен: {}", order);
        kafkaTemplate.send(topic, order);
    }
}
