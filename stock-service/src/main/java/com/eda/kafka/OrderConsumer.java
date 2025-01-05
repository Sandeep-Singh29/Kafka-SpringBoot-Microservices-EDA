package com.eda.kafka;

import com.eda.dto.Order;
import com.eda.dto.OrderEvent;
import com.eda.entity.OrderEntity;
import com.eda.repository.OrderRepository;
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

    private final OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void stockConsumer(OrderEvent orderEvent) {
        log.info("Order Event Received in Stock Service :: {}", orderEvent.toString());
        Order order = orderEvent.getOrder();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName(order.getName());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setQty(order.getQty());
        OrderEntity saveOrder = orderRepository.save(orderEntity);
        log.info("Order Details Saved SuccessFully :: {}", saveOrder.toString());
    }

}
