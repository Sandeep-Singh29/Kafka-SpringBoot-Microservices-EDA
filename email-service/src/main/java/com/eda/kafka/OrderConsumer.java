package com.eda.kafka;

import com.eda.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 03/01/25
 */

@Service
public class OrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void emailConsume(OrderEvent orderEvent){
        log.info("Order Event Received in Email Service :: {}", orderEvent.toString());
        // send message Logic
    }

}
