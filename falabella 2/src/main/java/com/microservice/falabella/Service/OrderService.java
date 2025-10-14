package com.microservice.falabella.Service;

import com.microservice.falabella.DTO.OrderDTO;
import com.microservice.falabella.Entity.Order;
import com.microservice.falabella.Entity.OrderStatus;
import com.microservice.falabella.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // ✅ Create order
    public Order createOrder(OrderDTO dto) {
        Order order = new Order();
        order.setLogisticOrderId(dto.getLogisticOrderId());
        order.setDestinationInfo(dto.getDestinationInfo());
        order.setCustomerInfo(dto.getCustomerInfo());
        order.setOrderStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    // ✅ Cancel order
    public Order cancelOrder(String logisticOrderId) {
        Order order = orderRepository.findByLogisticOrderId(logisticOrderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));

        if (order.getOrderStatus() == OrderStatus.DELIVERED) {
            throw new IllegalStateException("Cannot cancel a delivered order");
        }

        order.setOrderStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }
    public Order updateOrderStatus(String logisticOrderId, OrderStatus status) {
        Order order = orderRepository.findByLogisticOrderId(logisticOrderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }
}
