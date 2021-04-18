package com.huyehya.bot.loteria.api.strategies;

import com.huyehya.bot.loteria.api.DTOs.CombinationDTO;
import com.huyehya.bot.loteria.api.DTOs.GameDTO;
import com.huyehya.bot.loteria.api.contract.Rule;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.huyehya.bot.loteria.api.DTOs.GameEnum.LOTOFACIL;
import static com.huyehya.bot.loteria.api.DTOs.GameEnum.QUINA;

public class QuinaStrategy implements Rule {

    @Override
    public GameDTO generator(final int amountOfGames, final int amountOfNumbers){
        Random random = new Random();
        Set<Integer> results;
        Set<CombinationDTO> combinationDTOS = new HashSet<>();

        for (int quantity = 1; quantity <= amountOfGames; quantity++){
            results = new HashSet<>();
            while(results.size() < amountOfNumbers){
                final int number = random.nextInt(QUINA.getTotalNumber()) + 1;
                results.add(number);
            }
            final CombinationDTO combinationDTO = CombinationDTO.builder().id(quantity).result(results).build();
            combinationDTOS.add(combinationDTO);
        }
        return buildGame(combinationDTOS);
    }

    public GameDTO buildGame(final Set<CombinationDTO> combinationDTOs){


        return GameDTO.builder().name(QUINA.getName()).combinations(combinationDTOs).build();
    }
}
