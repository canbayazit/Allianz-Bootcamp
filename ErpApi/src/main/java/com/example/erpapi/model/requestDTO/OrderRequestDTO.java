package com.example.erpapi.model.requestDTO;

import com.example.erpapi.database.entity.CustomerEntity;
import com.example.erpapi.database.entity.OrderDetailEntity;
import com.example.erpapi.model.enums.OrderStatusEnum;
import com.example.erpapi.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class OrderRequestDTO extends BaseDTO {
    private CustomerRequestDTO customer;

    private OrderStatusEnum orderStatus;

    private List<OrderDetailRequestDTO> orderDetailList;

    private BigDecimal totalPrice;
}
