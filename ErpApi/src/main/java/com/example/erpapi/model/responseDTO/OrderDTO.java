package com.example.erpapi.model.responseDTO;

import com.example.erpapi.database.entity.CustomerEntity;
import com.example.erpapi.database.entity.OrderDetailEntity;
import com.example.erpapi.model.enums.OrderStatusEnum;
import com.example.erpapi.util.BaseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class OrderDTO extends BaseDTO {
    private CustomerDTO customer;

    private OrderStatusEnum orderStatus;

    private List<OrderDetailDTO> orderDetailList;

    private BigDecimal totalPrice;
}
