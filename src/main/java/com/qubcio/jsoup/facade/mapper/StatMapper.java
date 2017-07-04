package com.qubcio.jsoup.facade.mapper;

import com.qubcio.jsoup.model.dto.StatDto;
import com.qubcio.jsoup.model.entity.Stat;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@DecoratedWith(StatMapperDecorator.class)
public interface StatMapper {

    @Mapping(target = "champion", ignore = true)
    StatDto statToStatDto(Stat stat);
}
