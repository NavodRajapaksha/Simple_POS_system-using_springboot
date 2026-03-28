package edu.bootcamp.pos.service;

import edu.bootcamp.pos.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);
}
