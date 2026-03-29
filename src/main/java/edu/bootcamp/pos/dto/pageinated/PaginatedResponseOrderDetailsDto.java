package edu.bootcamp.pos.dto.pageinated;

import edu.bootcamp.pos.dto.respones.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponseOrderDetailsDto {
    private List<ResponseOrderDetailsDto> List;
    private long dataCount;
}
