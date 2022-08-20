package com.csm.canteen_management_system.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CustomerDto {
    @NotNull
    private String customerName;

    @NotNull
    private String customerDepartment;

    private String customerImage;

}
