package edu.bootcamp.pos.controller;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.request.RequestOrderSaveDto;
import edu.bootcamp.pos.service.OrderService;
import edu.bootcamp.pos.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem (@RequestBody RequestOrderSaveDto requestOrderSaveDto){
        String id = orderService.addOrder(requestOrderSaveDto);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id + "Success",id)
                , HttpStatus.CREATED
        );
    }
}
