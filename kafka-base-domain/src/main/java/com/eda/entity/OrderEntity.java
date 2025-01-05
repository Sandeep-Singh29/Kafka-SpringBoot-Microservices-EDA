package com.eda.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

/**
 * Author: SANDEEP
 * Date: 03/01/25
 */


@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(columnDefinition = "CHAR(36)", unique = true)
    private String orderId;
    private String name;
    private int qty;
    private double price;

    public OrderEntity() {
    }

    public OrderEntity(String orderId, String name, int qty, double price) {
        this.orderId = orderId;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
