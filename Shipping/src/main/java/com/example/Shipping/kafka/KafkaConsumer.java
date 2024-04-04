package com.example.Shipping.kafka;

import com.example.Shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final ShippingService service;

    @KafkaListener(topics = "payed_orders")
    public void consume(String order) {
        log.info("Заказ на сборке: {}", order);
        service.payOrder(order);
    }
}
