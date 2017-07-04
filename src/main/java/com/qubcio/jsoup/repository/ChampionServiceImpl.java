package com.qubcio.jsoup.repository;

import com.qubcio.jsoup.model.entity.Champion;
import com.qubcio.jsoup.service.ChampionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ChampionServiceImpl implements ChampionService {

    private final ChampionRepository championRepository;

    @Override
    @Transactional
    public Champion findById(Integer id) {
        return championRepository.findAllById(id);
    }
}
