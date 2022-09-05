package com.csm.canteen_management_system.service;

import com.csm.canteen_management_system.dto.OrderDto;

public interface OrderService {
    void saveOrder(OrderDto orderDto);
}
