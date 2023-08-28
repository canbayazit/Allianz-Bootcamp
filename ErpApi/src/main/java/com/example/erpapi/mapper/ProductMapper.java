package com.example.erpapi.mapper;


import com.example.erpapi.database.entity.ProductEntity;
import com.example.erpapi.model.requestDTO.ProductRequestDTO;
import com.example.erpapi.model.responseDTO.ProductDTO;
import com.example.erpapi.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {



    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());

        return dto;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());


        return entity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            ProductDTO dto = entityToDTO(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<ProductEntity> dtoListToEntityList(List<ProductDTO> productDTOS) {

        List<ProductEntity> entityList = new ArrayList<>();
        for (ProductDTO dto : productDTOS) {
            ProductEntity entity = dtoToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());


        return entity;
    }

    @Override
    public List<ProductEntity> requestDtoListToEntityList(List<ProductRequestDTO> productRequestDTOS) {
        return null;
    }

    @Override
    public ProductEntity requestDTOToExistEntity(ProductRequestDTO productRequestDTO, ProductEntity entity) {
        return null;
    }
}
