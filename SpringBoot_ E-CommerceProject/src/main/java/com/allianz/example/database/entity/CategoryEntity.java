package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class CategoryEntity extends BaseEntity {

    @Column
    private String name;


    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "categoryList")
    private Set<ProductEntity> productList = new HashSet<>();


}
