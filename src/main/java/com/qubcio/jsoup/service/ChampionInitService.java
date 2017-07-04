package com.qubcio.jsoup.service;

import com.qubcio.jsoup.model.entity.Champion;

import java.util.List;

public interface ChampionInitService {
    Champion createChampion(String championName);
    List<String> getAllChampionNames();
}
