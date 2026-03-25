package edu.bootcamp.pos.service.impl;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;
import edu.bootcamp.pos.entity.ItemEntity;
import edu.bootcamp.pos.repository.ItemRepository;
import edu.bootcamp.pos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSeriviceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

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
}
