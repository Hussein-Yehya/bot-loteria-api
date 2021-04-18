package com.huyehya.bot.loteria.api.contract;

import com.huyehya.bot.loteria.api.DTOs.GameDTO;

public interface Rule {

    public GameDTO generator(final int amountOfGames);
}
