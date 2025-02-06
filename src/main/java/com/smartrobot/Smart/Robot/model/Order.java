package com.smartrobot.Smart.Robot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationCode;
    private String pin;
    private String status;

    // Getter, Setter, Constructor
}


