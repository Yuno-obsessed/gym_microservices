package com.sanitynil.paymentservice.service;

import com.sanitynil.paymentservice.domain.order.entity.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.listen.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event){
        logger.info(String.format("Order event received in stock service => %s", event.toString()));

        // process the order
    }
}
