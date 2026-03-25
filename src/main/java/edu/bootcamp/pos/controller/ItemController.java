package edu.bootcamp.pos.controller;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;
import edu.bootcamp.pos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem (@RequestBody ItemDto itemDto){
        String message = itemService.saveItem(itemDto);
        return message;
    }

    @GetMapping(path = "/get-by-name", params = "name")
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDto> itemGetResponseDtos = itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDtos;
    }
}
