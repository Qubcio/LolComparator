package com.qubcio.jsoup.facade.mapper;

import com.qubcio.jsoup.model.dto.ChampionDto;
import com.qubcio.jsoup.model.entity.Champion;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@DecoratedWith(ChampionMapperDecorator.class)
public interface ChampionMapper {

    @Mapping(target = "stats", ignore = true)
    ChampionDto championToChampionDto(Champion champion);
}
