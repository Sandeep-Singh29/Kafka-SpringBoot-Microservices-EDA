package com.eda.controller;

import com.eda.dto.Order;
import com.eda.dto.OrderEvent;
import com.eda.kafka.OrderProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Author: SANDEEP
 * Date: 02/01/25
 */

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        log.info("Order DTO Data into OrderController placeOrder() :: {}",order.toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order is in Pending State");
        orderEvent.setOrder(order);
        orderProducer.sendOrderMessage(orderEvent); // Send Order in OrderEvent Using Order Producer
        return ResponseEntity.ok("Order Successfully...");
    }

}
