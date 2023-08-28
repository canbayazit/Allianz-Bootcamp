package com.example.erpapi.model.responseDTO;

import com.example.erpapi.database.entity.OrderEntity;
import com.example.erpapi.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class CustomerDTO extends BaseDTO {
    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private List<OrderDTO> orderList;
}
