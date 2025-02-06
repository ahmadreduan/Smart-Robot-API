package com.smartrobot.Smart.Robot.repository;

import com.smartrobot.Smart.Robot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByLocationCode(String locationCode);
}

