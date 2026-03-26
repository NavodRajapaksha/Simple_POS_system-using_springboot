package edu.bootcamp.pos.util.Mapper;

import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;
import edu.bootcamp.pos.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDto> entityListToDoList(List<ItemEntity> itemEntities);

    List<ItemGetResponseDto>ListDtoToPage(Page<ItemEntity> itemEntities);
}
