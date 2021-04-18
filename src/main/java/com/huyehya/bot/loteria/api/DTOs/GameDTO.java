package com.huyehya.bot.loteria.api.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@ToString
@Builder
@Data
public class GameDTO {

    private String name;
    private Set<CombinationDTO> combinations;

}
