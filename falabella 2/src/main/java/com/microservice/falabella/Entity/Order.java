package com.microservice.falabella.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String logisticOrderId;

    @Column(nullable = false)
    private String customerInfo;

    @Column(nullable = false)
    private String destinationInfo;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
