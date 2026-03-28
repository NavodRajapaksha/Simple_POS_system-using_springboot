package edu.bootcamp.pos.dto.request;

import edu.bootcamp.pos.entity.ItemEntity;
import edu.bootcamp.pos.entity.OrderEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderDetailSaveDto {

    private String itemName;
    private double Qty;
    private Double amount;
    private int itemEntity;
    private int orderEntity;
}

