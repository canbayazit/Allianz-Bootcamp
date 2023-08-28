package com.example.erpapi.database.entity;

import com.example.erpapi.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
public class BillEntity extends BaseEntity {
    @OneToOne
    private OrderEntity order;
    @Column
    private BigDecimal totalAmount;
}
