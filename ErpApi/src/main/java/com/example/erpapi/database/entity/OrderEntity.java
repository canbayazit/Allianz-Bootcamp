package com.example.erpapi.database.entity;

import com.example.erpapi.model.enums.OrderStatusEnum;
import com.example.erpapi.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class OrderEntity extends BaseEntity {
    @ManyToOne
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @OneToMany
    private List<OrderDetailEntity> orderDetailList;

    @Column
    private BigDecimal totalPrice;
}
