package com.csm.canteen_management_system.service.impl;

import com.csm.canteen_management_system.dto.OrderDto;
import com.csm.canteen_management_system.model.Order;
import com.csm.canteen_management_system.repo.OrderRepository;
import com.csm.canteen_management_system.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .orderedItems(orderDto.getOrderedItems())
                .orderQuantity(orderDto.getOrderQuantity())
                .build();
        orderRepository.save(order);
    }
}
