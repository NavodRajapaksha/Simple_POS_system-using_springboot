package edu.bootcamp.pos.dto.respones;

import edu.bootcamp.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDto {

    private int id;
    private String name;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;
}
