package com.csm.canteen_management_system.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ItemDto {
    @NotNull
    private String itemName;

    @NotNull
    private Long itemPrice;

    private String itemImage;
}
