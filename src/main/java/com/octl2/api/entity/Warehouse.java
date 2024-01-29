package com.octl2.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "bp_warehouse")
public class Warehouse {
    @Id
    @Column(name = "warehouse_id")
    private Long warehouseId;
}
