package edu.bootcamp.pos.service;

import edu.bootcamp.pos.dto.pageinated.PaginatedResponseOrderDetailsDto;
import edu.bootcamp.pos.dto.request.RequestOrderSaveDto;
import jakarta.validation.constraints.Max;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetailsDto getAllOrderDetails(boolean status, int page, @Max(50) int size);
}
