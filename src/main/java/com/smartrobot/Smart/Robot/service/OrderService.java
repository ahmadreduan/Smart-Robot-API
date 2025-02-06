package com.smartrobot.Smart.Robot.service;

import com.smartrobot.Smart.Robot.model.Order;
import com.smartrobot.Smart.Robot.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final Random random = new Random();

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // ✅ নতুন অর্ডার তৈরি + লোকেশন কোড + পিন জেনারেশন
    public Order createOrder(String locationCode) {
        Order order = new Order();
        order.setLocationCode(locationCode);
        order.setPin(String.valueOf(1000 + random.nextInt(9000)));  // ৪ ডিজিটের পিন
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    // ✅ লোকেশন কোড অনুযায়ী অর্ডার রিটার্ন
    public Optional<Order> getOrderByLocationCode(String locationCode) {
        return orderRepository.findByLocationCode(locationCode); // ✅ Optional<Order> রিটার্ন করবে
    }

    // ✅ পিন ভেরিফিকেশন + প্যাকেজ ডেলিভারি কনফার্ম
    public boolean verifyPin(String locationCode, String pin) {
        Optional<Order> optionalOrder = orderRepository.findByLocationCode(locationCode);

        if (optionalOrder.isPresent() && optionalOrder.get().getPin().equals(pin)) {
            Order order = optionalOrder.get();
            order.setStatus("DELIVERED");
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}

