package com.qubcio.jsoup.facade.mapper;

import com.qubcio.jsoup.model.dto.StatDto;
import com.qubcio.jsoup.model.entity.Stat;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class StatMapperDecorator implements StatMapper {

    @Autowired
    private StatMapper statMapper;

    @Override
    public StatDto statToStatDto(Stat stat) {
        StatDto statDto = statMapper.statToStatDto(stat);
        statDto.setChampion(stat.getChampion().getId());
        return statDto;
    }
}
