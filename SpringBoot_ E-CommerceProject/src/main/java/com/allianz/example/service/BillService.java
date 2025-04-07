package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.specification.BillSpecification;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        BillMapper, BillEntityRepository, BillSpecification> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;


    @Autowired
    BillSpecification billSpecification;

    @Override
    protected BillMapper getMapper() {
        return this.billMapper;
    }

    @Override
    protected BillEntityRepository getRepository() {
        return this.billEntityRepository;
    }

    @Override
    protected BillSpecification getSpecification() {
        return billSpecification;
    }

}
