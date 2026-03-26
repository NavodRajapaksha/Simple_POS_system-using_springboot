package edu.bootcamp.pos.service;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.pageinated.PageInatedResponseItemDto;
import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;

import java.util.List;

public interface ItemService {

    String saveItem(ItemDto itemDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDto> getItemByNameAndStatusByMapsstruct(String itemName);

    List<ItemGetResponseDto> getAllItemByStatus(boolean activeStatus);

    PageInatedResponseItemDto getAllItemByStatusWithPageInated(boolean activeStatus, int page, int size);
}
