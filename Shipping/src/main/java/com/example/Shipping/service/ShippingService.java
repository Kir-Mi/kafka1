package com.example.Shipping.service;

import com.example.Shipping.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShippingService {
    private final KafkaProducer producer;

    public void payOrder(Order order) {
        log.info("Заказ собран: {}", order);
        producer.sendMessage(order);
    }
}
