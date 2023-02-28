package com.sanitynil.paymentservice.infra.config.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitynil.paymentservice.domain.payment.entity.Payment;
import com.sanitynil.paymentservice.infra.config.exception.PaymentException;
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
public class PaymentProducer {

    @Value("${spring.kafka.topic.payment.name}")
    private String paymentTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Payment payment) throws JsonProcessingException {
        String paymentAsMessage = objectMapper.writeValueAsString(payment);
        kafkaTemplate.send(paymentTopic, paymentAsMessage);

        log.info("payment produced {}", paymentAsMessage);

    }

    public void sendMessageWithCallback(Payment payment) throws JsonProcessingException{
        String paymentAsMessage = objectMapper.writeValueAsString(payment);
        CompletableFuture.runAsync(() -> {
            try{
                kafkaTemplate.send(paymentTopic, paymentAsMessage);
            } catch (Throwable e){
                throw new PaymentException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
            log.info("Sent message=[{}] to topic {}", paymentAsMessage, paymentTopic);
        });
    }
}
