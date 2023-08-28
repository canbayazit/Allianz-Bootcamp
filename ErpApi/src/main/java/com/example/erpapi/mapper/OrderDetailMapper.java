package com.example.erpapi.mapper;

import com.example.erpapi.database.entity.OrderDetailEntity;
import com.example.erpapi.model.requestDTO.OrderDetailRequestDTO;
import com.example.erpapi.model.responseDTO.OrderDetailDTO;
import com.example.erpapi.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailMapper implements IBaseMapper<OrderDetailDTO, OrderDetailEntity, OrderDetailRequestDTO> {

    @Autowired
    ProductMapper productMapper;


    @Override
    public OrderDetailDTO entityToDTO(OrderDetailEntity entity) {
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        dto.setProduct(productMapper.entityToDTO(entity.getProduct()));
        dto.setQuantity(entity.getQuantity());
        dto.setSellPrice(entity.getSellPrice());

        return dto;
    }

    @Override
    public OrderDetailEntity dtoToEntity(OrderDetailDTO dto) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }

    @Override
    public List<OrderDetailDTO> entityListToDTOList(List<OrderDetailEntity> orderItemEntities) {

        List<OrderDetailDTO> dtoList = new ArrayList<>();
        for (OrderDetailEntity entity : orderItemEntities) {
            OrderDetailDTO dto = entityToDTO(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<OrderDetailEntity> dtoListToEntityList(List<OrderDetailDTO> OrderDetailDTOS) {
        List<OrderDetailEntity> entityList = new ArrayList<>();
        for (OrderDetailDTO dto : OrderDetailDTOS) {
            OrderDetailEntity entity = dtoToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }

    @Override
    public OrderDetailEntity requestDTOToEntity(OrderDetailRequestDTO dto) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setProduct(productMapper.requestDTOToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }

    @Override
    public List<OrderDetailEntity> requestDtoListToEntityList(List<OrderDetailRequestDTO> OrderDetailRequestDTOS) {
        List<OrderDetailEntity> entityList = new ArrayList<>();
        for (OrderDetailRequestDTO dto:OrderDetailRequestDTOS) {
            OrderDetailEntity entity =requestDTOToEntity(dto);
            entityList.add(entity);

        }
         return entityList;
    }

    @Override
    public OrderDetailEntity requestDTOToExistEntity(OrderDetailRequestDTO OrderDetailRequestDTO, OrderDetailEntity entity) {
        return null;
    }
}
