package com.qubcio.jsoup.service;

import com.qubcio.jsoup.model.entity.Champion;

public interface ChampionService {

    Champion findById(Integer id);
}
