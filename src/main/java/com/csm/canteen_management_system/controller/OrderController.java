package com.csm.canteen_management_system.controller;

import com.csm.canteen_management_system.dto.ApiResponse;
import com.csm.canteen_management_system.dto.OrderDto;
import com.csm.canteen_management_system.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    private ResponseEntity<ApiResponse> saveOrderItemByCustomer(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
        ApiResponse apiResponse = new ApiResponse("Order Save Successfully.", true, null);
        return ResponseEntity.ok(apiResponse);
    }

//    @GetMapping('customer/{customerId}')
//    private ResponseEntity<ApiResponse> getOrderListByCustomerId(){
//
//    }
}
