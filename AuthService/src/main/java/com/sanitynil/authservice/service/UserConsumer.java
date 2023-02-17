package com.sanitynil.authservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.listen.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Object mapping){
       logger.info("got an object");
    }
}
