package com.example.Payment.service;

import com.example.Payment.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayService {
    private final KafkaProducer producer;

    public void payOrder(Order order) {
        log.info("Заказ оплачен: {}", order);
        producer.sendMessage(order);
    }
}
