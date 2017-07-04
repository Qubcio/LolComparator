package com.qubcio.jsoup.facade;

import com.qubcio.jsoup.model.dto.ChampionDto;

public interface ChampionFacade {

    ChampionDto findById(Integer id);
}
