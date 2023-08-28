package com.example.erpapi.model.requestDTO;

import com.example.erpapi.database.entity.ProductEntity;
import com.example.erpapi.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderDetailRequestDTO extends BaseDTO {
    private ProductRequestDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
