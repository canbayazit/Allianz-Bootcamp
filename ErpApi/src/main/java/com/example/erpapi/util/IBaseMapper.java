package com.example.erpapi.util;
import java.util.List;

public interface IBaseMapper<DTO extends BaseDTO, Entity extends BaseEntity,RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity); // Entity'i DTO'ya çeviren abstract metot

    Entity dtoToEntity(DTO dto); // DTO2yu Entity'ye çeviren abstract metot

    List<DTO> entityListToDTOList(List<Entity> entityList);
    List<Entity> dtoListToEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);

    List<Entity> requestDtoListToEntityList(List<RequestDTO> dtoList);

    Entity requestDTOToExistEntity(RequestDTO requestDTO,Entity entity);
}
