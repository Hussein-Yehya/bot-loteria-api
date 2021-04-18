package com.huyehya.bot.loteria.api.DTOs;

import com.huyehya.bot.loteria.api.contract.Rule;
import com.huyehya.bot.loteria.api.strategies.LotofacilStrategy;
import com.huyehya.bot.loteria.api.strategies.LotomaniaStrategy;
import com.huyehya.bot.loteria.api.strategies.MegaSenaStrategy;
import com.huyehya.bot.loteria.api.strategies.QuinaStrategy;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum GameEnum {

    MEGASENA("megasena",6, 15, 60, new MegaSenaStrategy()),
    LOTOFACIL("lotofacil",15, 20, 25, new LotofacilStrategy()),
    QUINA("quina",5, 15, 80, new QuinaStrategy()),
    LOTOMANIA("lotomania",50, 50, 100, new LotomaniaStrategy());

    private String name;
    private int minimumNumber;
    private int maximumNumber;
    private int totalNumber;
    private Rule rule;

    GameEnum(final String name,final int minimumNumber, final int maximumNumber, final int totalNumber, final Rule rule) {
        this.name = name;
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
        this.totalNumber = totalNumber;
        this.rule = rule;
    }

    public static GameEnum identifyRule(String name) {
        return Stream.of(GameEnum.values()).filter(gameEnum -> name.equals(gameEnum.getName())).findFirst().orElse(null);
    }


}
