package com.example.erpapi.database.entity;

import com.example.erpapi.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class ProductEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private Integer quantity;
    @OneToMany(mappedBy = "product")
    private List<OrderDetailEntity> orderDetails;
}
