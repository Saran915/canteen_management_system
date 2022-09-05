package com.csm.canteen_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String orderQuantity;

    @OneToMany(targetEntity = Items.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "io_fk", referencedColumnName = "orderId")
    private List<Items> orderedItems = new ArrayList<>();
}
