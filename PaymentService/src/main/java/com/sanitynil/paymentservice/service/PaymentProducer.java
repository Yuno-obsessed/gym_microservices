package com.sanitynil.paymentservice.service;

import com.sanitynil.paymentservice.domain.payment.entity.PaymentEvent;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentProducer {
    private static final Logger logger = LoggerFactory.getLogger(PaymentProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, PaymentEvent> kafkaTemplate;

   public void sendMessage(PaymentEvent event){
       logger.info(String.format("Payment event => %s", event.toString()));

       Message<PaymentEvent> message = MessageBuilder
               .withPayload(event)
               .setHeader(KafkaHeaders.TOPIC, topic.name())
               .build();
       kafkaTemplate.send(message);
   }
}
