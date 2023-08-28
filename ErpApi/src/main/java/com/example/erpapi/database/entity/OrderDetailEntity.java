package com.example.erpapi.database.entity;

import com.example.erpapi.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
public class OrderDetailEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;
    @Column
    private Integer quantity;
    @Column
    private BigDecimal sellPrice;
}
