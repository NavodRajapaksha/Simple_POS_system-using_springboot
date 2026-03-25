package edu.bootcamp.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer id;
    private String name;
    private String address;
    private List<String> contactNumber;
    private String nic;
    private boolean active;
}
