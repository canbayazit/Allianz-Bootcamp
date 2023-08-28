package com.example.erpapi.model.responseDTO;

import com.example.erpapi.database.entity.OrderEntity;
import com.example.erpapi.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BillDTO extends BaseDTO {
    private OrderDTO order;
    private BigDecimal totalAmount;
}
