//package com.sanitynil.orderservice.service;
//
//import com.sanitynil.orderservice.infra.util.PaymentStatus;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentConsumer {
//    private static final Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);
//
//    @KafkaListener(
//            topics = "${spring.kafka.topic.listen.name}",
//            groupId = "${spring.kafka.consumer.group-id}"
//    )
//    public void consume(PaymentStatus event){
//        logger.info(String.format("Order event received in stock service => %s", event.toString()));
//
//        // process the order
//    }
//}
