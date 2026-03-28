package edu.bootcamp.pos.controller;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.pageinated.PageInatedResponseItemDto;
import edu.bootcamp.pos.dto.respones.ItemGetResponseDto;
import edu.bootcamp.pos.service.ItemService;
import edu.bootcamp.pos.util.StandardResponse;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

//    @PostMapping(path = "/save")
//    public String saveItem (@RequestBody ItemDto itemDto){
//        String message = itemService.saveItem(itemDto);
//        return message;
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem (@RequestBody ItemDto itemDto){
        String message = itemService.saveItem(itemDto);

//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"Success",message)
//                        , HttpStatus.CREATED
//        );
//        return response;

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message)
                , HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-by-name", params = "name")
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDto> itemGetResponseDtos = itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDtos;
    }

    @GetMapping(path = "/get-by-name-with-mapstruct", params = "name")
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapsstruct(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDto> itemGetResponseDtos = itemService.getItemByNameAndStatusByMapsstruct(itemName);
        return itemGetResponseDtos;
    }

    @GetMapping(path = "/get-all-items-by-status", params = {"page","size"})
    public ResponseEntity<StandardResponse> getAllItemsByStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50)int size
            ){
//      List<ItemGetResponseDto> itemGetResponseDtos = itemService.getAllItemByStatus(activeStatus,page,size);

        PageInatedResponseItemDto pageInatedResponseItemDto = itemService.getAllItemByStatusWithPageInated(activeStatus,page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",pageInatedResponseItemDto)
                , HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-all-active-items-paginated", params = {"page","size","activeStatus"})
    public ResponseEntity<StandardResponse> getAllActiveItemPageInated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50)int size,
            @RequestParam(value = "activeStatus") boolean activeStatus
    ){
        PageInatedResponseItemDto pageInatedResponseItemDto = itemService.getAllActiveItemPageInated(activeStatus,page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",pageInatedResponseItemDto)
                , HttpStatus.CREATED
        );
    }

}
