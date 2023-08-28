package com.example.erpapi.mapper;

import com.example.erpapi.database.entity.BillEntity;
import com.example.erpapi.model.requestDTO.BillRequestDTO;
import com.example.erpapi.model.responseDTO.BillDTO;
import com.example.erpapi.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO dto = new BillDTO();
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> dtoList = new ArrayList<>();
        for (BillEntity entity :billEntities) {
            BillDTO dto = entityToDTO(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<BillEntity> dtoListToEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> entityList = new ArrayList<>();
        for (BillDTO dto :billDTOS) {
            BillEntity entity = dtoToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setOrder(orderMapper.requestDTOToEntity(dto.getOrder()));

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<BillEntity> requestDtoListToEntityList(List<BillRequestDTO> billRequestDTOS) {
        return null;
    }

    @Override
    public BillEntity requestDTOToExistEntity(BillRequestDTO billRequestDTO, BillEntity entity) {
        return null;
    }
}
