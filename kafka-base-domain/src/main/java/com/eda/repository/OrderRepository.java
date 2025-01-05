package com.eda.repository;

import com.eda.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: SANDEEP
 * Date: 03/01/25
 */

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String> {
}
