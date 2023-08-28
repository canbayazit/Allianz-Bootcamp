package com.example.erpapi.model.responseDTO;

import com.example.erpapi.database.entity.ProductEntity;
import com.example.erpapi.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderDetailDTO extends BaseDTO {
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
