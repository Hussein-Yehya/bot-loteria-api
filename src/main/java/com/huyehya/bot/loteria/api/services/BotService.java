package com.huyehya.bot.loteria.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.huyehya.bot.loteria.api.DTOs.GameDTO;
import com.huyehya.bot.loteria.api.DTOs.GameEnum;
import com.huyehya.bot.loteria.api.contract.Rule;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
public class BotService {

    public GameDTO gamesGenerator(final int amountOfGames, final String name, final Integer amountOfNumbers){
        GameEnum gameEnum = GameEnum.identifyRule(name);

        if (Objects.isNull(gameEnum)){
            log.info("No games defined");
            return null;
        }

        final GameDTO generator = gameEnum.getRule().generator(amountOfGames);
        System.out.println(generator);
        return generator;
    }
}
