package com.csm.canteen_management_system.controller;

import com.csm.canteen_management_system.dto.CustomerDto;
import com.csm.canteen_management_system.model.Customer;
import com.csm.canteen_management_system.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    private ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Customer save successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    private ResponseEntity<?> getCustomerList() {
        List<Customer> customerList = customerService.getCustomerList();
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Customer list get successfully.");
        response.put("data", customerList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    private ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Customer updated successfully.");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Customer delete successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    private ResponseEntity<?> getCustomerById(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        Customer customer = customerService.getCustomerById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Customer get successfully");
        response.put("data", customer);
        return ResponseEntity.ok(response);
    }
}
