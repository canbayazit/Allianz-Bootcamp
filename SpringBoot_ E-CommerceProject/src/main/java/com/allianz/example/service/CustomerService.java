package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.specification.CustomerSpecification;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, CustomerRequestDTO,
        CustomerMapper, CustomerEntityRepository, CustomerSpecification> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    protected CustomerMapper getMapper() {
        return this.customerMapper;
    }

    @Override
    protected CustomerEntityRepository getRepository() {
        return this.customerEntityRepository;
    }

    @Override
    protected CustomerSpecification getSpecification() {
        return null;
    }
}
