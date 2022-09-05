package com.csm.canteen_management_system.dto;

import com.csm.canteen_management_system.model.Items;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    @NotNull
    private String orderQuantity;

    @NotNull
    private List<Items> orderedItems = new ArrayList<>();
}
