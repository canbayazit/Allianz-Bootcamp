package com.example.erpapi.model.requestDTO;

import com.example.erpapi.database.entity.OrderEntity;
import com.example.erpapi.util.BaseDTO;
import lombok.Data;

import java.util.List;
@Data
public class CustomerRequestDTO extends BaseDTO {
    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private List<OrderRequestDTO> orderList;
}
