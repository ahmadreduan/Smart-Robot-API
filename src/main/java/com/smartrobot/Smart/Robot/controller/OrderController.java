package com.smartrobot.Smart.Robot.controller;

import com.smartrobot.Smart.Robot.model.Order;
import com.smartrobot.Smart.Robot.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // order create API
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam String locationCode) {
        Order order = orderService.createOrder(locationCode);
        return ResponseEntity.ok(order);
    }

    // Location onujaiye order details return API
    @GetMapping("/get/{locationCode}")
    public ResponseEntity<Order> getOrderByLocation(@PathVariable String locationCode) {
        Optional<Order> order = orderService.getOrderByLocationCode(locationCode);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //location update api
    @PostMapping("/update-location")
    public ResponseEntity<String> updateLocation(@RequestParam String locationCode, @RequestParam String latitude, @RequestParam String longitude) {
        System.out.println("Received Location: " + latitude + ", " + longitude);
        return ResponseEntity.ok("Location Updated!");
    }



    // pin verification API
    @PostMapping("/verify")
    public ResponseEntity<String> verifyPin(@RequestParam String locationCode, @RequestParam String pin) {
        boolean success = orderService.verifyPin(locationCode, pin);
        if (success) {
            return ResponseEntity.ok("Package Delivered Successfully!");
        } else {
            return ResponseEntity.status(400).body("Invalid PIN!");
        }
    }
}
