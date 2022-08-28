package com.csm.canteen_management_system.repo;

import com.csm.canteen_management_system.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
