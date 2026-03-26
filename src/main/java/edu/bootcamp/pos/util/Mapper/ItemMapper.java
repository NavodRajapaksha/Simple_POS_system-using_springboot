package edu.bootcamp.pos.util.Mapper;

import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;
import edu.bootcamp.pos.entity.ItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDto> entityListToDoList(List<ItemEntity> itemEntities);
}
