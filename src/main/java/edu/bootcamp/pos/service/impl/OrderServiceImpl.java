package edu.bootcamp.pos.service.impl;

import edu.bootcamp.pos.dto.request.RequestOrderSaveDto;
import edu.bootcamp.pos.entity.OrderDetailsEntity;
import edu.bootcamp.pos.entity.OrderEntity;
import edu.bootcamp.pos.repository.CustomerRepository;
import edu.bootcamp.pos.repository.ItemRepository;
import edu.bootcamp.pos.repository.OrderDetailRepository;
import edu.bootcamp.pos.repository.OrderRepository;
import edu.bootcamp.pos.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Character.getType;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    private final OrderDetailRepository orderDetailRepository;

    private final ItemRepository itemRepository;

    @Override
    public String addOrder(RequestOrderSaveDto requestOrderSaveDto) {
        OrderEntity orderEntity = new OrderEntity(
                customerRepository.getById(requestOrderSaveDto.getCustomerId()),
                requestOrderSaveDto.getDate(),
                requestOrderSaveDto.getTotal()
        );
        orderRepository.save(orderEntity);

        if (orderRepository.existsById(orderEntity.getId())) {
            List<OrderDetailsEntity> orderDetailsEntities1 = modelMapper.
                    map(requestOrderSaveDto.getOrderDetailsEntities(),
                            new TypeToken<List<OrderDetailsEntity>>(){}.getType());
            for (int i=0; i<orderDetailsEntities1.size();i++){
                 orderDetailsEntities1.get(i).setOrderEntity(orderEntity);
                 orderDetailsEntities1.get(i).setItemEntity(
                         itemRepository.getById(
                                 requestOrderSaveDto.getOrderDetailsEntities().get(i).getItemEntity()
                         )
                 );
            }
            if (orderDetailsEntities1.size()>0){
                orderDetailRepository.saveAll(orderDetailsEntities1);
            }

            return "saved";
        }
        return null;
    }
}
