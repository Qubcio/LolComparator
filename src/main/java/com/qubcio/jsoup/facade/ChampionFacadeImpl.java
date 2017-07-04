package com.qubcio.jsoup.facade;

import com.qubcio.jsoup.facade.mapper.ChampionMapper;
import com.qubcio.jsoup.model.dto.ChampionDto;
import com.qubcio.jsoup.service.ChampionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChampionFacadeImpl implements ChampionFacade {

    private final ChampionService championService;
    private final ChampionMapper championMapper;

    @Override
    public ChampionDto findById(Integer id) {
        return championMapper.championToChampionDto(championService.findById(id));
    }
}
