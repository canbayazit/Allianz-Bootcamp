package com.allianz.example.database.entity;

import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class ProductEntity extends BaseEntity {


    @Column
    private String name;

    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column
    private BigDecimal sellPrice;

    @Column
    private BigDecimal buyPrice;

    @Column
    private Integer quantity;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<CategoryEntity> categoryList = new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER)
    private TaxEntity tax;


}
