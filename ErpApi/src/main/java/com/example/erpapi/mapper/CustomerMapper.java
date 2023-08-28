package com.example.erpapi.mapper;

import com.example.erpapi.database.entity.CustomerEntity;
import com.example.erpapi.model.requestDTO.CustomerRequestDTO;
import com.example.erpapi.model.responseDTO.CustomerDTO;
import com.example.erpapi.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    @Lazy
    OrderMapper orderMapper;

    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        dto.setOrderList(orderMapper.entityListToDTOList(entity.getOrderList()));
        return dto;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {

        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setOrderList(orderMapper.dtoListToEntityList(dto.getOrderList()));
        return entity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {
        List<CustomerDTO> dtoList = new ArrayList<>();
        for (CustomerEntity entity : customerEntities) {
            CustomerDTO dto = entityToDTO(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<CustomerEntity> dtoListToEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> entityList = new ArrayList<>();
        for (CustomerDTO dto : customerDTOS) {
            CustomerEntity entity = dtoToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {

        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());


        return entity;
    }

    @Override
    public List<CustomerEntity> requestDtoListToEntityList(List<CustomerRequestDTO> customerRequestDTOS) {
        return null;
    }

    @Override
    public CustomerEntity requestDTOToExistEntity(CustomerRequestDTO customerRequestDTO, CustomerEntity entity) {
        return null;
    }
}
