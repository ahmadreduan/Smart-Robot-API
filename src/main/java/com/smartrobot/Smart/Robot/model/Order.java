package com.smartrobot.Smart.Robot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String locationCode;

    private String pin;
    private String status;
}


//@Entity
//@Data
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String locationCode;
//    private String pin;
//    private String status;
//
//    // Getter, Setter, Constructor
//}


