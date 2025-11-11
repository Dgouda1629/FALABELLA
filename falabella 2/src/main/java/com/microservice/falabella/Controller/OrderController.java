package com.microservice.falabella.Controller;


import com.microservice.falabella.DTO.OrderDTO;
import com.microservice.falabella.Entity.Order;
import com.microservice.falabella.Entity.OrderStatus;
import com.microservice.falabella.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")


public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDTO dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));

    }

    @PutMapping("/{logisticOrderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable String logisticOrderId) {
        return ResponseEntity.ok(orderService.cancelOrder(logisticOrderId));

    }

    @PutMapping("/{logisticOrderId}/status")
    public ResponseEntity<Order>updateStatus(@PathVariable String logisticOrderId, @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(logisticOrderId, status));
    }

    @GetMapping("/{logisticOrderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String logisticOrderId) {
        return ResponseEntity.ok(orderService.getOrder(logisticOrderId));
    }

}
