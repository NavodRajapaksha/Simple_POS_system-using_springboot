package edu.bootcamp.pos.service;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;

import java.util.List;

public interface ItemService {

    String saveItem(ItemDto itemDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);
}
