package com.csm.canteen_management_system.service.impl;

import com.csm.canteen_management_system.dto.CustomerDto;
import com.csm.canteen_management_system.model.Customer;
import com.csm.canteen_management_system.repo.CustomerRepository;
import com.csm.canteen_management_system.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .customerName(customerDto.getCustomerName())
                .customerDepartment(customerDto.getCustomerDepartment())
                .customerImage(customerDto.getCustomerImage())
                .build();
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public void updateCustomer(Integer id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerDepartment(customerDto.getCustomerDepartment());
        customer.setCustomerImage(customer.getCustomerImage());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
        customerRepository.delete(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
    }
}
