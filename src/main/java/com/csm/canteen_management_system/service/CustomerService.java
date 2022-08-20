package com.csm.canteen_management_system.service;

import com.csm.canteen_management_system.dto.CustomerDto;
import com.csm.canteen_management_system.model.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    List<Customer> getCustomerList();

    void updateCustomer(Integer id, CustomerDto customerDto);

    void deleteCustomer(Integer id);

    Customer getCustomerById(Integer id);
}
