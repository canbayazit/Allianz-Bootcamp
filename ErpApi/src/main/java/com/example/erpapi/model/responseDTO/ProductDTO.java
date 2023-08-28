package com.example.erpapi.model.responseDTO;

import com.example.erpapi.database.entity.OrderDetailEntity;
import com.example.erpapi.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class ProductDTO extends BaseDTO {
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private List<OrderDetailDTO> orderDetails;
}
