package edu.bootcamp.pos.dto.respones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class ResponseOrderDetailsDto {
    //Customer
    private String CustomerName;
    private String customerAddress;
    private ArrayList contactNumber;

    //order
    private Data date;
    private Double total;
}
