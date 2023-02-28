package com.sanitynil.orderservice.infra.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopic {

    @Value("${spring.kafka.topic.name}")
    private String topicName;
    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(topicName)
                .build();
    }

    @Bean
    KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }
}
