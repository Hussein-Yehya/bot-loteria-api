package com.huyehya.bot.loteria.api.controllers;

import com.huyehya.bot.loteria.api.DTOs.GameDTO;
import com.huyehya.bot.loteria.api.services.BotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("v1/bot")
@CrossOrigin("*")
@Slf4j
public class BotController {

    @Autowired
    private BotService botService;


    @GetMapping(value = "/game/generators", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDTO> gameGenerator(@RequestParam("amountOfGames") final int amountOfGames, @RequestParam("name") final String name,
                                                 @RequestParam(value = "amountOfNumbers", required = false) final Integer amountOfNumbers){

        GameDTO gameDTO = botService.gamesGenerator(amountOfGames, name, amountOfNumbers);

        log.info("Resultados: {}",gameDTO.toString());
        return ResponseEntity.ok(gameDTO);
    }

}
