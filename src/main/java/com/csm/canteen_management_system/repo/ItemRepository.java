package com.csm.canteen_management_system.repo;

import com.csm.canteen_management_system.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Integer> {
}
