package com.qubcio.jsoup.facade.mapper;

import com.qubcio.jsoup.model.dto.ChampionDto;
import com.qubcio.jsoup.model.entity.Champion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public abstract class ChampionMapperDecorator implements ChampionMapper {

    private ChampionMapper championMapper;
    private StatMapper statMapper;

    @Autowired
    private void init(ChampionMapper championMapper, StatMapper statMapper) {
        this.championMapper = championMapper;
        this.statMapper = statMapper;
    }

    @Override
    public ChampionDto championToChampionDto(Champion champion) {
        ChampionDto championDto = championMapper.championToChampionDto(champion);
        championDto.setStats(champion.getStats().stream().map(e -> statMapper.statToStatDto(e)).collect(Collectors.toList()));
        return championDto;
    }
}
