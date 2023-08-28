package com.example.erpapi.mapper;

import com.example.erpapi.database.entity.OrderEntity;
import com.example.erpapi.model.requestDTO.OrderRequestDTO;
import com.example.erpapi.model.responseDTO.OrderDTO;
import com.example.erpapi.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    @Lazy
    CustomerMapper customerMapper;

    @Autowired
    OrderDetailMapper orderItemMapper;

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        dto.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setOrderDetailList(orderItemMapper.entityListToDTOList(entity.getOrderDetailList()));

        return dto;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderDetailList(orderItemMapper.dtoListToEntityList(dto.getOrderDetailList()));
        entity.setTotalPrice(dto.getTotalPrice());

        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        return null;
    }

    @Override
    public List<OrderEntity> dtoListToEntityList(List<OrderDTO> orderDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderDetailList(orderItemMapper.requestDtoListToEntityList(dto.getOrderDetailList()));
        entity.setTotalPrice(dto.getTotalPrice());
        return entity;
    }

    @Override
    public List<OrderEntity> requestDtoListToEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToExistEntity(OrderRequestDTO orderRequestDTO, OrderEntity entity) {
        return null;
    }
}
