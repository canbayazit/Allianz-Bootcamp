package com.example.erpapi.database.entity;

import com.example.erpapi.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class CustomerEntity extends BaseEntity {
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    private List<OrderEntity> orderList;
}
