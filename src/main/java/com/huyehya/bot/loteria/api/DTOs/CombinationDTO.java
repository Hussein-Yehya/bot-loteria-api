package com.huyehya.bot.loteria.api.DTOs;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CombinationDTO {

    private int id;
    private Set<Integer> result = new HashSet<>();
}
