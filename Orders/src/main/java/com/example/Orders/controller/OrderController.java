package com.example.Orders.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/orders")
public class OrderController {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${application.kafka.topic}")
    private String topic;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        log.info("Заказ принят: {}", order);
        kafkaTemplate.send(topic, order);
    }
}
