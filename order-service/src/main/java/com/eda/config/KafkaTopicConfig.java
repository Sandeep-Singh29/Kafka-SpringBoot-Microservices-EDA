package com.eda.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Author: SANDEEP
 * Date: 02/01/25
 */

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topic;

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(topic)
                .build();
    }

}
