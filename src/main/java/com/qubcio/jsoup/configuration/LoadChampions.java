package com.qubcio.jsoup.configuration;

import com.qubcio.jsoup.service.ChampionInitService;
import com.qubcio.jsoup.repository.ChampionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class LoadChampions implements CommandLineRunner {


    private final ChampionInitService championInitService;
    private final ChampionRepository championRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        if (championRepository.findAll().size() == 0) {
            championInitService.getAllChampionNames().forEach(e ->
                    championRepository.save(championInitService.createChampion(e)));
        }
    }
}
