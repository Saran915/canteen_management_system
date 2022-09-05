package com.csm.canteen_management_system.controller;

import com.csm.canteen_management_system.dto.ApiResponse;
import com.csm.canteen_management_system.dto.CustomerDto;
import com.csm.canteen_management_system.model.Customer;
import com.csm.canteen_management_system.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    private ResponseEntity<ApiResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        ApiResponse apiResponse = new ApiResponse("Customer save successfully", true, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    private ResponseEntity<ApiResponse> getCustomerList() {
        List<Customer> customerList = customerService.getCustomerList();
        ApiResponse apiResponse = new ApiResponse("Customer list get successfully", true, customerList);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{id}")
    private ResponseEntity<ApiResponse> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        ApiResponse apiResponse = new ApiResponse("Customer updated successfully", true, null);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        ApiResponse apiResponse = new ApiResponse("Customer delete successfully", true, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("{id}")
    private ResponseEntity<ApiResponse> getCustomerById(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        Customer customer = customerService.getCustomerById(id);
        ApiResponse apiResponse = new ApiResponse("Customer get successfully", true, customer);
        return ResponseEntity.ok(apiResponse);
    }
}
