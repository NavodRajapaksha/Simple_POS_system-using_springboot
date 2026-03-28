package edu.bootcamp.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderSaveDto {

    private int customerId;
    private Date date;
    private Double total;
    private List<RequestOrderDetailSaveDto> orderDetailsEntities;
}
