package edu.bootcamp.pos.service.impl;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.pageinated.PageInatedResponseItemDto;
import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;
import edu.bootcamp.pos.entity.ItemEntity;
import edu.bootcamp.pos.exception.NotFoundException;
import edu.bootcamp.pos.repository.ItemRepository;
import edu.bootcamp.pos.service.ItemService;
import edu.bootcamp.pos.util.Mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSeriviceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    private final ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDto itemDto) {

        ItemEntity itemEntity = modelMapper.map(itemDto,ItemEntity.class);

        if (!itemRepository.existsById(itemEntity.getId())){
            itemRepository.save(itemEntity);
            return itemEntity.getId()+ " Saved Succefully";
        }else {
            throw new RuntimeException("Already added");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
        boolean active = true;
        List<ItemEntity> itemEntityList = itemRepository.findAllByNameEqualsAndActive(itemName,active);

        if (itemEntityList.size()>0){
            List<ItemGetResponseDto> itemGetResponseDtos = modelMapper.map(itemEntityList,
                    new TypeToken<List<ItemGetResponseDto>>(){}
                            .getType());
            return itemGetResponseDtos;
        }else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapsstruct(String itemName) {
        boolean active = true;
        List<ItemEntity> itemEntityList = itemRepository.findAllByNameEqualsAndActive(itemName,active);

        if (itemEntityList.size()>0){
            List<ItemGetResponseDto> itemGetResponseDtos = itemMapper.entityListToDoList(itemEntityList);
            return itemGetResponseDtos;
        }else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDto> getAllItemByStatus(boolean activeStatus) {
        List<ItemEntity> itemEntityList = itemRepository.findAllByActiveEquals(activeStatus);

        if (itemEntityList.size()>0){
            List<ItemGetResponseDto> itemGetResponseDtos = itemMapper.entityListToDoList(itemEntityList);
            return itemGetResponseDtos;
        }else {
            throw new NotFoundException("Item is not active");
        }
    }

    @Override
    public PageInatedResponseItemDto getAllItemByStatusWithPageInated(boolean activeStatus, int page, int size) {
        Page<ItemEntity> itemEntities = itemRepository.findAllByActive(activeStatus, PageRequest.of(page,size));
        if (itemEntities.getSize()<1){
            throw new NotFoundException("No Data");
        }

        PageInatedResponseItemDto pageInatedResponseItemDto = new PageInatedResponseItemDto(
                itemMapper.ListDtoToPage(itemEntities),
                itemRepository.countAllByActiveEquals(activeStatus)
        );
        return pageInatedResponseItemDto;
    }

    @Override
    public PageInatedResponseItemDto getAllActiveItemPageInated(boolean activeStatus, int page, int size) {
        Page<ItemEntity> itemEntities = itemRepository.findAllByActiveEquals(activeStatus, PageRequest.of(page,size));
        return new PageInatedResponseItemDto(
                itemMapper.ListDtoToPage(itemEntities),
                itemRepository.count()
        );
    }
}
