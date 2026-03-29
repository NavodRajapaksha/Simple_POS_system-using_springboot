package edu.bootcamp.pos.controller;

import edu.bootcamp.pos.dto.ItemDto;
import edu.bootcamp.pos.dto.pageinated.PaginatedResponseOrderDetailsDto;
import edu.bootcamp.pos.dto.request.RequestOrderSaveDto;
import edu.bootcamp.pos.service.OrderService;
import edu.bootcamp.pos.util.StandardResponse;
import jakarta.validation.constraints.Max;
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

    @GetMapping(
            params = {"statusType", "page", "size"},
            path = "/get-order-details"
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "statusType") String statusType,
            @RequestParam(value = "page")  int page,
            @RequestParam(value = "size") @Max(50)int size
    ){
        PaginatedResponseOrderDetailsDto p = null;
        if (statusType.equalsIgnoreCase("active") | ( statusType.equalsIgnoreCase("inactive"))){
            boolean status = statusType.equalsIgnoreCase("active") ? true : false;
            p = orderService.getAllOrderDetails(status,page,size);
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", p),
                HttpStatus.OK
        );
    }
}
