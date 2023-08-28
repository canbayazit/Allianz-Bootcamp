package com.example.erpapi.model.requestDTO;

import com.example.erpapi.database.entity.OrderEntity;
import com.example.erpapi.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BillRequestDTO extends BaseDTO {
    private OrderRequestDTO order;
    private BigDecimal totalAmount;
}
