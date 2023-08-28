package com.example.erpapi.model.requestDTO;

import com.example.erpapi.database.entity.OrderDetailEntity;
import com.example.erpapi.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class ProductRequestDTO extends BaseDTO {
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private List<OrderDetailRequestDTO> orderDetails;
}
