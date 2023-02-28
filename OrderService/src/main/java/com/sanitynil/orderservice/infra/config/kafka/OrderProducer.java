package com.sanitynil.orderservice.infra.config.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitynil.orderservice.domain.order.entity.Order;
import com.sanitynil.orderservice.infra.config.exception.OrderException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


@Slf4j
@Component
@RequiredArgsConstructor
public class OrderProducer {

    @Value("${spring.kafka.topic.order.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Order order) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(order);
        kafkaTemplate.send(orderTopic, orderAsMessage);

        log.info("order produced {}", orderAsMessage);

    }

    public void sendMessageWithCallback(Order order) throws JsonProcessingException{
        String orderAsMessage = objectMapper.writeValueAsString(order);
        CompletableFuture.runAsync(() -> {
            try{
                kafkaTemplate.send(orderTopic,orderAsMessage);
            } catch (Throwable e){
                throw new OrderException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
            log.info("Sent message=[{}] to topic {}", orderAsMessage, orderTopic);
        });
    }
}
