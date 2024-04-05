package com.example.Payment.kafka;

import com.example.Payment.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final PayService payService;

    @KafkaListener(topics = "new_orders")
    public void consume(Order order) {
        log.info("Заказ на оплате: {}", order);
        payService.payOrder(order);
    }
}
